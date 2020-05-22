while (true) {
    Thread.sleep(500L);
    String update = getUpdate();
    SwingUtilities.invokeLater(new Runnable() {   
        public void run() {
            textArea.append(update);
        }
    });
}