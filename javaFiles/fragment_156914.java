if( e.getActionCommand().equals("Pause")){
    growPanel.pause();
    setText("Resume");
} else {
    growPanel.startPaiting();
    setText("Pause");
}