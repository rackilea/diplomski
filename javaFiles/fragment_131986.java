public static boolean isOverriden(Method parent, Method toCheck) {
    if (parent.getDeclaringClass().isAssignableFrom(toCheck.getDeclaringClass())
            && parent.getName().equals(toCheck.getName())) {
         Class<?>[] params1 = parent.getParameterTypes();
         Class<?>[] params2 = toCheck.getParameterTypes();
         if (params1.length == params2.length) {
             for (int i = 0; i < params1.length; i++) {
                 if (!params1[i].equals(params2[i])) {
                     return false;
                 }
             }
             return true;
         }
    }
    return false;
}