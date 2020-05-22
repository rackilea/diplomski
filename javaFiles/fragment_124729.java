int numFoo = 0;
int numBar = 0;

void foo(){
    enter(0);
    //stuff
    leave(0);
}

void bar(){
    enter(1);
    //Stuff
    leave(1);
}

//Synchronized makes no more than one thread can run this simultaneously, so they wont be any race condition
synchronized void enter(int id){
    //If it was foo entering
    if (id == 0){
        while(numBar != 0)//Waits until theres none executing bar
            try {
                this.wait();
            } catch (InterruptedException e) {e.printStackTrace();}
        numFoo++;//Enters
    }
    else{
        while(numFoo !=0)//Waits until none executes foo
            try { 
                this.wait();
            } catch (InterruptedException e) { e.printStackTrace();}
        numBar++;//Enters
    }
}

synchronized void leave(int id){
    if (id == 0){
        numFoo--;
        if(numFoo == 0)//If it was the last executing foo unlocks the others
            this.notifyAll();
        }
    else{
        numBar--;
        if(numBar == 0)//If it was the last executing bar unlocks the others
            this.notifyAll();
    }
}