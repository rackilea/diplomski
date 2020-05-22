boolean lastWasElse = false;


 mHandler.post(new Runnable() {

       @Override
       public void run() {

           if(true) {
                //  do this
                lastWasElse = false;
           } else if (!lastWasElse) {
                  // do once and then loop again, but if the answer is still "else" then skip this line.
                lastWasElse = true;
           }
       }