ClassA classA=new ClassA();
       Field[] fields =classA.getClass().getDeclaredFields();
       for (Field field : fields) {
           if (Collection.class.isAssignableFrom(field.getType())){
               System.out.println(field.getName());//you can remove this as per requirement
               Class<?> c1 = (Class<?>) ((((ParameterizedType) field.getGenericType()).getActualTypeArguments())[0]);

                Field[] fieldsInner = c1.getDeclaredFields();
                for (Field fieldInner : fieldsInner) {
                    System.out.println(fieldInner.getName());

           }
           else{
           System.out.println(field.getName());}

       }