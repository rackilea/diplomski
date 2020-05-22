public String showList(){
    ...//some code
    (new Thread(new doSomething())).start(); //more efficient: create a 
                                             //variable to hold the thread.
    return retStr;
}