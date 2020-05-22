val x: Long = seconds
val timer = new java.util.Timer()
timer.scheduleAtFixedRate(new java.util.TimerTask {
  def run(): Unit = {
    // this will be executed every x seconds
  }
}, 0L, x * 1000L)