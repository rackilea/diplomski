class ExpireTask extends TimerTask
{
  YourClass callbackClass;

  ExpireTask(YourClass callbackClass)
  {
    this.callbackClass = callbackClass;
  }

  public void run()
  {
    callbackClass.timeExpired()
  }
}