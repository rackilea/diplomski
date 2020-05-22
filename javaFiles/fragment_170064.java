Thread yourThread = new Thread(new Runnable() {

@Override
public void run() {
    try  {
        //Put your code in here
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
});

yourThread .start();