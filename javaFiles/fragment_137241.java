public void doSomething() throws SomeException{

    try{

        doSomethingThatCanThrowException();

    } catch (SomeException e){

       e.addContextInformation(“more info”);
       throw e;  //throw e, or wrap it – see next line.

       //throw new WrappingException(e, “more information”);

    } finally {
       //clean up – close open resources etc.
    }

}