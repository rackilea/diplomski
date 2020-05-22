public class MainActivity extends Activity {

     boolean breakIsRunning = false;
     boolean startIsRunning = false;

        Button btnStart,btnBreak;

        CountDownTimer startTimer = new CountDownTimer(amountOfStudyTime, countDownInterval)
        {

            @Override
            public void onFinish() {
               //do something
               startIsRunning = false;
            }

            @Override
            public void onTick(long arg0) {
                //do something
                startIsRunning = true;
            }

        };



    CountDownTimer breakTimer = new CountDownTimer(amountOfBreakTime, countDownInterval)
            {

                @Override
                public void onFinish() {
                   //do something
                   breakIsRunning  = false;
                }

                @Override
                public void onTick(long arg0) {
                    //do something
                    breakIsRunning = true;
                }

            };


 //->OnCreate() - >Buttons code

     btnStart.setOnClickListener(new OnClickListener().. { // your listener code here
          if(breakIsRunning)
             breakTimer.cancel();
          startTimer.start();
    }

     btnBreak.setOnClickListener(new OnClickListener().. { //
           if(startIsRunning)
              startTimer.cancel();
           breakTimer.start();
    }

}