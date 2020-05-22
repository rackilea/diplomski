object SomeObject { outer =>
  def myMethodOfSomeInstance = {
    val uiThread = new SomeClass {
      def run: Unit = {
        chooser.showOpenDialog(outer)
      }
    }
  }
}