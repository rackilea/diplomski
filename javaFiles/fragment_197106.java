String search = filenameText.getText();
File root = new File(dirName);
resultText.setText("");

Loading show = new Loading();
show.setVisible(true);
displayDirectoryContents(root, search);
show.setVisible(false);