public void classSync() {
   synchronized( TestClass.class ) {
       System.out.println("...");
       testList.add( 1 );
   }
}