void process(String string, Do doA, Do doB) {

    if(nullOrEmpty(string)){
        if (getConfig() != null) {doA.doSometing(); }   
    }else {
        doB.doSometing();
    }
}