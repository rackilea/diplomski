public class SongTimer{
 int count;
 long duration;
 int groupAddress;
 SongTimerListener listener;
 boolean timer,run;
 View user; //the view who this is going to be attached to

 public interface SongTimerListener {
     public void onPositionCounted(int position);
     public void onFinishCounting();
 }
 //your constructor
 public SongTimer(int position, long duration, int groupAddress,
           SongTimerListener listener, View viewToAttach){  //added new parameter
     this.listener = listener;
     this.count = position;
     this.duration = duration;
     this.groupAddress = groupAddress;
     timer = run = true;
     user = viewToAttach;
     new Thread(new Runnable() { // your timer 

        @Override
        public void run() {
            while(run){
              if(!timer)
                 continue;
               //now add your implementation here, (its too late here)
       //put your code that you already have here, but minor changes
       //if you need to call a Ui method use the user.post(runnable); it
       // the same as handler.post(runnable), also with this you have 
      // reference to your view to which you want to alter, so all you
      // to do is do what you want to do easily without actually needing
     // your interface call. and all Views that they rely on the music
     //mechanism that you talked about will each have an instance of this
    //class. your pausing mechanism has already being implemented so 
   //maintain your old pausing mechanism. Also if you are done and want 
   // totally stop the thread or kill this class set the boolean run 
   //variable to false.

        }
    }).start();
 }