Runnable r1=null;
for(int i=0; i<2; i++) {
  Runnable r2=Runtime.getRuntime()::gc;
  if(r1==null) r1=r2;
  else {
    System.out.println(r1==r2? "shared": "unshared");
    System.out.println(
        r1.getClass()==r2.getClass()? "shared class": "unshared class");
  }
}