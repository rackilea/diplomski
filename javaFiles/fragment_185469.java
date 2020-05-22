public class Main {
    public static void main(final String[] args) throws InterruptedException {
        final JFrame frame = new JFrame("Swing canvas");
        frame.setBounds(100, 100, 640, 480);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final CanvasPanel canvasPanel = new CanvasPanel();
        frame.getContentPane().add(canvasPanel);
        frame.setVisible(true);
        final List<String> words = Arrays.asList("one", "ein", "une", "uno", "jeden", "een");
        for (final String word : words) {
            canvasPanel.addWord(word);
            // Dirty way to simulate some heavy translation work...
            Thread.sleep(246);
        }
    }
}

class CanvasPanel extends JPanel {
    private final List<String> words = new ArrayList<>();

    public void addWord(final String word) {
        words.add(word);
        repaint();
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        for (int wordIndex = 0; wordIndex < words.size(); wordIndex++)
            graphics.drawString(words.get(wordIndex), 42, 64 + 28 * wordIndex);
    }
}