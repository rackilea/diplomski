public void method1() {
     try {
        //3rd party code here....
     }
     catch(RuntimeException e){
         throw e;
     }
     catch(Exception e){
       throw new RuntimeException(e.getMessage(),e);
     }
}