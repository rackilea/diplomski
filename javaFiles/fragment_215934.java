void test() {
        Type superclass = this.getClass().getGenericSuperclass();
        if (ParameterizedType.class.isAssignableFrom(superclass.getClass())) {
            ParameterizedType genericSuperclass = (ParameterizedType) superclass;
            Class enumClass = (Class) genericSuperclass.getActualTypeArguments()[0];
            for (Object o : enumClass.getEnumConstants()) {
                System.out.println(o);
            }
        }
    }