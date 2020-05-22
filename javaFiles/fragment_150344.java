class MyRunnable implements Runnable 
{
 boolean isUpdateEnabled = true;
 Object myUpdateLockObj = new Object();

 @Override
 public void run() {
    // Retrieve list from Internet. takes about 10 sec to complete.
    if (isUpdateEnabled) {
        runOnUiThread(new Runnable() {
            public void run() {
                lock(myUpdateLockObj)
                {
                   if (!isUpdateEnabled) return;
                }
                //do work in parts
                System.out.print("Update");

                lock(myUpdateLockObj)
                {
                   if (!isUpdateEnabled) return;
                }
                // do work in parts
                System.out.print(" UI");
            }
        });
    }
  }

  void enableUpdate(boolean enable) 
  {
    synhronized(myUpdateLockObj)
    {
        isUpdateEnabled = enable;
    }
  }
}