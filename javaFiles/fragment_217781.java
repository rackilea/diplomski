void run(){
     //...
     C c = ...; // passed in from somewhere
     if ( goBackToTheQueueAgain == true ){
         setChanged();
         notifyObservers();//notify C that to let B add itself back
     }
     else
         c.notifyDone(this);
}