final Handler handler = new Handler();
final long delay = 5 * 60 * 1000;

void executeSomething(){
    handler.postDelayed(new Runnable(){
        public void run(){
            // do your work

            if (continueToExecute){
                executeSoemthing();
            }
        }
    }, delay);
}