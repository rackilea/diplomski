public static String getName(final Class<?> clazz) {
   if (!clazz.isArray()) {
     return clazz.getName();
   } else {
     return getName(clazz.getComponentType()) + "[]";
   }
 }