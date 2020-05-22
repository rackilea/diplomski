class MyFrame extends JFrame {
    //...
    public MyFrame() {
        super("Example");   
        JTextArea textArea = new JTextArea();
        textArea.setSize(800, 600);
        add(textArea, BorderLayout.CENTER);

        JButton btn = new JButton("Send");
        add(btn, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800); 
        setVisible(true);
    }
}