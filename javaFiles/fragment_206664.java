import javax.swing.{JComponent, KeyStroke} // Java world

val calculator = new CalcGrid
val frame = new Frame{
  title = "Calculator"
  val panel = calculator.CalcPanel()      
  contents = panel
  val act1 = Action("key1") {
    calculator.numTxt.text += "1"
  }
  // the mapping is done in your top component, so `panel`.
  // you must use the input map which is active whenever the window
  // in which the panel is located has focus:
  val imap = panel.peer.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
  val amap = panel.peer.getActionMap
  // you need to map a KeyStroke to an (arbitrarily chosen) action name,
  // and that action name to the action itself.
  imap.put(KeyStroke.getKeyStroke(Key.Numpad1.id, 0), "key1")
  imap.put(KeyStroke.getKeyStroke(Key.Key1   .id, 0), "key1") // can map several keys
  amap.put("key1", act1.peer)

  size = new Dimension(200,270)
  centerOnScreen()
  resizable = false
}
frame.open()