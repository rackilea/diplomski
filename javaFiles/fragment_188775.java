public static Iterable<Field> getFieldsUpTo(@Nonnull Class<?> startClass, 
                                   @Nullable Class<?> exclusiveParent) {

   List<Field> currentClassFields = Lists.newArrayList(startClass.getDeclaredFields());
   Class<?> parentClass = startClass.getSuperclass();

   if (parentClass != null && 
          (exclusiveParent == null || !(parentClass.equals(exclusiveParent)))) {
     List<Field> parentClassFields = 
         (List<Field>) getFieldsUpTo(parentClass, exclusiveParent);
     currentClassFields.addAll(parentClassFields);
   }

   return currentClassFields;
}