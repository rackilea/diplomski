public void testOne(){
    callMe("testOne");
}

public void testTwo(){
    callMe("testTwo");
}

public void callMe(String methodName){
    System.out.println("I was called by following method."+methodName);     
}