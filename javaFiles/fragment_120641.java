static String ClassName = null;

 public Foo() {
     if(ClassName == null)
         ClassName = this.getClass().getCanonicalName();
 }