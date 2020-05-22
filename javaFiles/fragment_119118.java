public boolean checkCollisions(){
    boolean didSomething = false;
    if (someCondition) {
       doSomething();
       didSomething = true;
    }
    else if (condition2) {
       doSomething2();
       didSomething = true;
    } 
    else if (condition3){
       doSomething3();
       didSomething = true;
    }
    return didSomething;
}