@Override
public void run() {
while (true) {
    try 
    {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        return;
    }
    potato++;
    runOnUiThread(new Runnable()
    {
        @Override
        public void run()
        {
           potatoDisp();
        }
    });
   }
}