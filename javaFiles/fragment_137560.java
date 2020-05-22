Class<?> c;
    try {
        c = Class.forName("Bar");
        Method meths[] = c.getMethods();
        Method v1method = null;
        Method v2method = null;
        for(Method m:meths) {
            if(!m.getName().equals("librarycall")) continue;
            if(!Modifier.isStatic(m.getModifiers())) {
                System.out.println("Should be static");
                continue;
            }
            Class<?> params[] = m.getParameterTypes();
            if(params.length == 1 && params[0].equals(String.class) )
                v1method = m;
            if(params.length == 2 && params[0].equals(String.class) && params[1].equals(Integer.TYPE) )
                v2method = m;
        }
        if(v2method!=null) {
            v2method.invoke(null,"V2",5);
        }
        else if(v1method!=null) {
            v1method.invoke(null,"V1");
        }
        else
            System.out.println("No method found");

    } catch (ClassNotFoundException e) {
        System.out.println(e);
    } catch (IllegalArgumentException e) {
        System.out.println(e);
    } catch (IllegalAccessException e) {
        System.out.println(e);
    } catch (InvocationTargetException e) {
        System.out.println(e);
    }