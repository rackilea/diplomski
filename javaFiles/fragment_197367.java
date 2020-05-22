public void myActualMethod(){
    for(Method m : registeredMethodsToCallBeforeActualCode){
        m.invoke();
    }

    //my actual code

    // here you can also write a for loop to execute all the methods which you want to call after your actual code is executed.

}