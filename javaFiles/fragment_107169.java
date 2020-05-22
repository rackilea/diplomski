public class Quest{

    CallBack cb;

    interface CallBack{
        public void callBack();
    }

    //add some way to set the call back, such as setter (or use constructor)
    public void setCB(CallBack cb){ this.cb = cb;}

  //Inside the action listener of your quest doing something
  ...
    cb.callBack(); //call the callback method when you are done and want to do your check (it calls the beginner class back)