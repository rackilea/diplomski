private void someOtherMethod() {
    try {
        // something that might throw
    } catch (CannotReadException | ReadOnlyFileException | IOException
             | InvalidAudioFrameException | TagException ex) {
        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
}