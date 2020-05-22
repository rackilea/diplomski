class ExceptionWrapper {
    public Exception exception;
}

@Override
public void run() throws MyCustomException{
       final ExceptionWrapper ew = new ExceptionWrapper();

       FOO.doSomething(new Transactable(){
           public void run(FOO foo) {
               try {
                   ...
               } catch(MyCustomException ex) {
                   ew.exception = ex;
               }
           }
        });             

        if(ew.exception != null) throw (MyCustomException)ew.exception;
}