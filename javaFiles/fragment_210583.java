protected Integer doInBackground() throws Exception{
    //Downloads and unzips the first video.  
    if(cameraBoolean==true) // just use if(cameraBoolean), since this is a boolean
        panel.add(this.downloadRecording(camera, recording)); // NO!
    else
        panel.add(new JLabel("Could not contact camera "+camera.getName())); //NO!

    panel.repaint(); //NO, never!
    jframe.repaint();//NO, never!
    return 1;
}