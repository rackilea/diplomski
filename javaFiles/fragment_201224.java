class BadFoo{
    //bad, VERSION could be inlined
    //and later when we change the version, other classes will have the old value!
   public static final int VERSION =1;

}

class BetterFoo{
   private static int version =1;

   //outside classes must call method getVersion()
   //field version can not be inlined at compile time.
   //JIT may inline at runtime which is OK
   public static final int getVersion(){
      return version;
   }

}