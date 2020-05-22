class GenUpperBound<T> {

   T obj;

   public <U extends Number> void set(U obj) {
      this.obj=obj;
   }

   ...
}