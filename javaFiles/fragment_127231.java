void method1(){
    SuperType randomInstance = getRandomInstance();
    if (randomInstance instanceof Stoppable) {
        Stoppable sInstance = (Stoppable) randomInstance;
        if(sInstance.getStop() == ...) //do something
    }
}