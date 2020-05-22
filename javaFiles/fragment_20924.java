String fileName=null;
JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "MP3 Files", "mp3");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(parent);
    if(returnVal == JFileChooser.APPROVE_OPTION) {
       fileName=     chooser.getSelectedFile().getName();
    }
MediaPlayer mediaPlayer = new MediaPlayer(new Media(fileName));
mediaPlayer.play();