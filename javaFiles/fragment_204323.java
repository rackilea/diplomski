LearningLetterPanel()  {
    try {
        RandomImagePane();
    } catch (IOException e) {
        throw new RuntimeException(e.getMessage(), e);
    }
    letterThread = new Thread(this);
    letterThread.start();
}