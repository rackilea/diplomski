void pause(){
     synchronized(suspender){
         isPaused = true;        
     }
}

void resume(){
     synchronized(suspender){
         isPaused = false;
         suspender.notify();
     }
}

while (true){
    if(loader.isInterrupted()){
        return;
    }

    // this outside loop is needed to deal with spurious wakeup
    synchronized (suspender){
        while(isPaused){            
            suspender.wait();
        }
    }

    ...
}