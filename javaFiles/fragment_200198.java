private void configureOrekit() throws MyException{
    try {
       method logic...
} catch (OrekitException oe) {
   throw new MyException("message useful...", oe);       
}