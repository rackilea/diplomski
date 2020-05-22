public class Console extends JFrame
{
    private final JTextArea text;

    private final DocumentListener docListener = new DocumentListener()
    {
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            System.out.println("String inserted");
            // This is called when text is inserted into the JTextArea
            // Similar to a user typing
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            System.out.println("String removed");
            // This is called when text is removed from the JTextArea
            // Similar to a user backspacing
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            // This isn't all that necessary because it doesn't apply to JTextAreas
        }
    };

    public Console()
    {
        text = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Console");

        text.setBackground(new java.awt.Color(0, 0, 0));
        text.setColumns(40);
        text.setForeground(new java.awt.Color(0, 255, 0));
        text.setRows(10);
        text.setText("I am a console!");
        text.setCaretColor(new java.awt.Color(0, 255, 0));
        Document doc = new PlainDocument();
        doc.addDocumentListener(docListener);
        text.setDocument(doc);
        getContentPane().add(new JScrollPane(text), java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }                       

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Console().setVisible(true);
            }
        });
    }
}