LineListener listener = new LineListener() {
        public void update(LineEvent event) {
        if (event.getType() == Type.STOP) {
          btnPlay.setEnabled(true);
        }        
        }
    };
clip.addLineListener(listener);