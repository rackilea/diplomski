String[] params = new String[] {"jack", "25"};
Object[] realParams = new Object[params.length];
Method[] methods = getClass().getMethods();
for (Method method : methods) {
  if (method.getParameterTypes().length == params.length) {
     for (int i = 0; i < method.getParameterTypes().length; i ++) {
        Class<?> paramClass = method.getParameterTypes()[i];
        if (paramClass = String.class) {
           realParams.add(param);
        } else if (paramClass == Integer.class || paramClass == Integer.TYPE) {
           realParams.add(Integer.parseInt(param));
        } else if (other primitive wrappers) {
            ...
        } else {
          realParams.add(null); // can't create a random object based on just string
          // you can have some object factory here, or use ObjectInputStream
        }
     }
     break; // you can continue here if the parameters weren't converted successfully,     
     //to attempt another method with the same arguments count.
  }
}