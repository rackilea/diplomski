class Test {
  val mThread = new Thread {
    override def run {
      println("hello")
      run
    }
  }
  mThread.start
}