private class Bar {
   private List<String> fooStrings;

   public Bar() {
     this.fooStrings = new Foo().getStrings();
   }
}