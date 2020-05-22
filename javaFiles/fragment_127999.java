public void run() {
    //MainActivityInstance.setText(MyService.this.counter); somthing like that
    MyService.this.counter++;
    Intent intentBroadcast = new Intent("MainActivity");
    intentBroadcast.putExtra("counter",MyService.this.counter);
    sendBroadcast(intentBroadcast);
    if(counter == 1000)
    timer.cancel();
}