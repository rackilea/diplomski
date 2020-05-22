Method[] methods = Customer.class.getDeclaredMethods();
     Class<?>[] methodParams = null;
     Object[] paramValue = new Object[1];

     for (Method method : methods) {

       if(method.getName().contains("set")) //This is for set methods. 
       {
           methodParams = method.getParameterTypes();
           if(methodParams[0].equals(String.class))
           {
               paramValue[0] = "some string"; // Assigning some value to method parameter
           }

           method.invoke(customer, paramValues); // customer is your object you are executing your methods on.
       }
    }