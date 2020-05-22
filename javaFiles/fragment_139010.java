public class myReceiveThread extends Thread{
        public gotNewData listener;

        //Create an interface to pass data to Activity
        public interface gotNewData(){
            void gotNewDataToDisplay(String data); //or int or data or what ever.
        }

        //CTor
        public myThread(gotNewData listener){
            this.listener = listener;
        }

        @Override
        public void run(){
            while(myAppisRunnung == true){



                //Receive Data
                listener.gotNewDataToDisplay("New Data");
            }
        }
        }