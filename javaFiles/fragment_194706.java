while(! ready){
    try{
        mySynchonizedObject.wait(); 
    }catch(InterruptedException ex){
        System.exit(1);
    }
}