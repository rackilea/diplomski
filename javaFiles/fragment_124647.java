//MainMethod

    public static class InvokeMain 
        {
            public static void main(String... args) throws Throwable 
            {
                Object obj1 = getBean("www.Fouth.User");

                System.out.println(obj1.toString());
            }

        }

    //Customize Method


      public static void extractMethod(Method[] method,Object valueObj,Object classObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
        {
            for(Method m:method)
            {   
                Type[] pType = m.getGenericParameterTypes();

                for(int i=0;i<pType.length; i++)
                {
                    System.out.println("The pType[]"+pType[i]);         

                    if(valueObj.getClass().equals(pType[i]))
                    {   
                        m.setAccessible(true);
                        m.invoke(classObj,valueObj.getClass().toString().valueOf(valueObj));
                    }
                }
            }

        }

      //ReflectionMethod


    public static Object getBean(String beanClassName) throws Exception
        {
            Class klass = Class.forName(beanClassName);
            Object obj = klass.newInstance();               
            Method[] b = klass.getDeclaredMethods();

            RefLevel3.extractMethod(b,"sanket",obj);
            RefLevel3.extractMethod(b,23,obj);


            return obj;
        }