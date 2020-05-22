AudioClip currentAudio = null;

...

private void lbl01MouseReleased(java.awt.event.MouseEvent evt){                                    
    String val=txtdisplay.getText() +"1";
    txtdisplay.setText(val);
    if ( currentAudio != null ){
        currentAudio.stop();
    }
    if (evt.getSource() == lbl01) 
    {

        URL urlClick = StartGUI.class.getResource("/Dtmf/dtmf1.wav");
        currentAudio = Applet.newAudioClip(urlClick);
        currentAudio.play();
    }
}