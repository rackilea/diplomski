public class MyJFrame extends JFrame {
    // Here, keep everything you already have

    public JFrame() {
        // Here, keep everything you already have

        // Let's assume your ScorePanel instance is here:
        final ScorePanel scorePanel = new ScorePanel();

        this.gamePan.addMyEventListener(new MyEventListener() {
            @Override
            public void wordFound(/* any data you could use */) {
                // Update your application using any data you can use :)
                scorePanel.wordFound(/* any data you could use */);
            }
        });
    }
}