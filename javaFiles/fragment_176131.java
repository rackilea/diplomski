public SampleDialog(JComponent parent, String title){
    super((Frame)SwingUtilities.getAncestorOfClass(Frame.class, parent), title, false);
    init();
    setLocationRelativeTo(parent);
  }

init(){
  // initialization code goes here
  pack();
}