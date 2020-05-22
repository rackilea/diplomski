final InetAddress ip = socket.getInetAddress();
restrictedIPs.add(ip);

restrictTimer.schedule(new TimerTask()
{
  public void run()
  {
    restrictedIPs.remove(ip);
  }

},  MIN_REQUEST_INTERVAL);