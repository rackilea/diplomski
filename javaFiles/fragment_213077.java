int counter = 0;
 int delayInMs = 5000; // 5 seconds
 Handler timer = new Handler(new Handler.Callback() {

 @Override
 public boolean handleMessage(Message msg) {
   counter++;
   // If the counter is mod 5 (or whatever) lower the delay
   if (counter % 5 == 0) {
     delayInMs/=100; // Or any other calculation.
   } 
   // If the counter reaches 100 the counting will not continue.
   if (counter <= 100) {
     // If the counter has not reached the condition to stop, the handler
     // will call the timer again with the modified (or not) delay.
     timer.sendEmptyMessageDelayed(0, delayInMs);

     // Change progress
     updateProgress(counter);
   }
   return true;
 }
});
// ...

// Somwhere in the code to start the counter
timer.sendEmptyMessageDelayed(0, delayInMs); // starts the timer with the initial 5 sec delay.