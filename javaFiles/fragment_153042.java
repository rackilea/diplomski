Iterator<TypeA> iterA = ....;
Iterator<TypeB> iterB = Iterators.transform(iterA, new Function<TypeA, TypeB>() {
   @Override
   public TypeB apply(TypeA input) {
     TypeB output = ...;// rules to create TypeB from TypeA
     return output;
   }
});