//Global
Handler h = new Handler();

private static boolean flag = true;

public void updateTextView(){

 // call thread here
 h.post(thread);
}


  // take this thread out side so that it can be stopped with handler
 Thread thread = new Thread(){

 public void run(){

      while(flag)
      outCPU.setText(getCpuInfo());

    }

 }

public void onBackPressed(){

    flag = false;
    h.removeCallBacks(thread);
    super.onBackPressed();

}