public static Object getBean(String beanClassName) throws Exception {
    Class klass = Class.forName(beanClassName); // ->Get Class Name By Path
    Object obj = klass.newInstance(); // ->Create The Object of Class
    Method[] b = klass.getDeclaredMethods(); // ->Get Declared Method in
                                                // Class

    for (Method m : b) {
        Type[] pType = m.getGenericParameterTypes();
        if(pType.length==0){
            continue;
        }
        /**
         * Create new array to hold value of parameters
         */
        Object[] params = new Object[pType.length];

        for (int i = 0; i < pType.length; i++) {
            System.out.println("The Arguments :" + pType[i] + " Arguments Order :" + i);
            if (pType[i].equals(String.class)) {
                params[i] = "Hello";

            } else if (pType[i].equals(int.class)) {
                params[i] = 21;                 
            }

        }
        m.setAccessible(true);
        /**
         * Invoke method with all paramtters.
         */
        m.invoke(obj, params);
    }

    return obj;
}