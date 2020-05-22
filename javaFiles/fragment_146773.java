public void someMethod() {
try {
RootProcess process = new RootProcess(Runtime.getRuntime().exec("su"));
}
catch(IOException ex){
//handle it here
}
}