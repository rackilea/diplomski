final Type[] types = {a, b};
 ParameterizedType type = ParameterizedType() {
   @Override
   public Type[] getActualTypeArguments() {
     return types;
   }

   @Override
   public Type getOwnerType() {
     return null;
   }

   @Override
   public Type getRawType() {
     return MyClass.class;
   };
}