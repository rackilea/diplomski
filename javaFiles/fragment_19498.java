final Handler mHandler = new Handler() { 

  public void handleMessage(Message msg) 
  { 
       //get your data here
       int something = msg.arg1; 
  } 
}; 

public void myMethodInsideActivity{
    new MyTask(this, mHandler).execute();
}