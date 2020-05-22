private void handle(Exception ex) {
    Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
}

private void someOtherMethod() {
    try {
        // something that might throw
    } catch (CannotReadException ex) {
        handle(ex);
    } catch (ReadOnlyFileException ex) {
        handle(ex);
    } catch (IOException ex) {
        handle(ex);
    } catch (InvalidAudioFrameException ex) {
        handle(ex);
    } catch (TagException ex) {
        handle(ex);
    }
}