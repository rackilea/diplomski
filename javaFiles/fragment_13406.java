boolean isFarNotEmpty (Foo foo){
   return foo != null && 
          foo.bar != null && 
          foo.bar.boo != null && 
          foo.bar.boo.far != null;
}