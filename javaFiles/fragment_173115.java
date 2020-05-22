fileChooser_2 = new JFileChooser();
returnVal_2 = fileChooser_2.showSaveDialog(frame);

if (returnVal_2 == JFileChooser.APPROVE_OPTION) {
  savePath = fileChooser_2.getCurrentDirectory();
  System.out.println("yes");
} else if (returnVal_2 == JFileChooser.CANCEL_OPTION) {
  System.out.println("no");
}