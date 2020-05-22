class WorkerThread extends Thread {
     int someDataYouNeed;
     MyHttpFileUploader maybeAClassYouNeedToCommunicateWithAtEnd;
     boolean hasNotFinishedTask = true;
     WorkerThread(int someDataYouNeed, MyHttpFileUploader callBackClass) {
         this.someDataYouNeed = someDataYouNeed;
         this.maybeAClassYouNeedToCommunicateWithAtEnd = callBackClass;
     }

     public void run() {

         while(hasNotFinishedTask){
         //do your work in here 
         //Try contact network endpoint
         try{
             //do a network call and if it doesnt except
             hasNotFinishedWork = false
             //now callback to the class firing a method maybe (I just made one up)
             maybeAClassYouNeedToCommunicateWithAtEnd.Close();
         }catch(TheException ex){ //do nothing or log }
         if(hasNotFinishedTask){
              Thread.Sleep(60000);//retry every minute
            }
         }
     }
 }