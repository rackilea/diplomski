MyPanel myPanel = new MyPanel();
int result = JOptionPane.showConfirmDialog(someComponent, myPanel);
if (result == JOptionPane.OK_OPTION) {
  String text1 = myPanel.getField1Text(); 
  // ..... String text2 = ...... etc .....
  // .... .use the results here
}