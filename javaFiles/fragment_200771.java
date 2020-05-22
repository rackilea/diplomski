public void populateObject(Object object, final Map elements) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, IntrospectionException,
            IllegalArgumentException, JSONException, InstantiationException {

        Class clazz = object.getClass();

        // if it is a proxy, find the actual type behind it
        if(Advised.class.isAssignableFrom(clazz)){
            clazz = ((Advised)object).getTargetSource().getTargetClass();
        }

        BeanInfo info = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] props = info.getPropertyDescriptors();

        // iterate over class fields
        for (int i = 0; i < props.length; ++i) {
            PropertyDescriptor prop = props[i];
            String name = prop.getName();

            if (elements.containsKey(name)) {
                Object value = elements.get(name);
                Method method = prop.getWriteMethod();

                if (method != null) {
                    JSON json = method.getAnnotation(JSON.class);
                    if ((json != null) && !json.deserialize()) {
                        continue;
                    }

                    // use only public setters
                    if (Modifier.isPublic(method.getModifiers())) {
                        Class[] paramTypes = method.getParameterTypes();


                        Type[] genericTypes = method.getGenericParameterTypes();

                        if (paramTypes.length == 1) {
                            Object convertedValue = this.convert(paramTypes[0], genericTypes[0], value,
                                    method);
                            method.invoke(object, new Object[] { convertedValue });
                        }
                    }
                }
            }
        }
    }