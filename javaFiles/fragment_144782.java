public class JScrollPaneExample extends JPanel{

    public JScrollPaneExample(int rowCount){

        setLayout(new BorderLayout());

        final JScrollPane scrollPane = makeScrollPane(rowCount);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                scrollPane.getVerticalScrollBar().setValue(0);

            }
        });
        add(scrollPane, BorderLayout.PAGE_START);
        setPreferredSize(new Dimension(300,300));
    }

    private JScrollPane makeScrollPane(int rowCount) {
        final JScrollPane scrollPane = new JScrollPane();

        final JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(rowCount, 0));

        for(int i = 0; i < rowCount; i++){
            if(i != 4)
                pane.add(makeTestField("Test " + (i+1), "Test description: " + (i+1), i));
            else {
                pane.add(makeTestField("This is a test", 
                        "This is also a test to see if this field will do a line break. "
                                + "This is also a test to see if this field will do a line break. "
                                + "Something else could be entirely different...", 
                                i));
            }
        }

        scrollPane.getViewport().add(pane);
        scrollPane.setPreferredSize(new Dimension(200, 400));   
        return scrollPane;
    }

    protected static JPanel makeTestField(String header, String description, int rowCount){ 
        final JPanel testField = new JPanel();

        testField.setLayout(new BorderLayout());
        testField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        final JLabel label = new JLabel(header);
        final Font font = new Font("Serif", Font.BOLD, 18);
        label.setFont(font);

        final JButton btn = new JButton("Start");

        final JTextArea textArea = new JTextArea(description);
        textArea.setEditable(false);
        textArea.setBackground(label.getBackground());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));

        testField.add(label, BorderLayout.PAGE_START);
        testField.add(textArea, BorderLayout.CENTER);
        testField.add(btn, BorderLayout.LINE_END);

        return testField;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);

                final JFrame frame = new JFrame();
                final JPanel scrollPane = new JScrollPaneExample(8);
                frame.add(scrollPane);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(500,500));
                frame.pack();
            }
        });
    }
}