Test obj = new Test();
        for (Method m : obj.getClass().getDeclaredMethods()){
            if (m.getName().startsWith("get") && m.getParameterTypes().length == 1) {
                System.out.println("==="+m.getName());
                if (m.getReturnType().equals(String.class)) {
                    String value = "ABCD";
                    Method  method = Test.class.getDeclaredMethod (m.getName(), String.class);
                    method.invoke (obj, value);
                }
            }
        }