object Main extends swing.SwingApplication {
  override def startup(args: Array[String]) {
    val logFrame = LogFrame
    if (logFrame.size == new Dimension(0,0)) logFrame.pack()
    logFrame.visible = true
  }
}