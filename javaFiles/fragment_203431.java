public class InClass1Main extends JFrame {

    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;

    public static void main(String[] args) {
        new InClass1Main();
    }

    public InClass1Main() {

        Toolkit tk = Toolkit.getDefaultToolkit();

        Dimension dim = tk.getScreenSize();
        this.setSize((dim.width / 2), (dim.height / 2));
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);

        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Translation Panel");
        JButton button1 = new JButton("Transfer");

        ListenForButton button = new ListenForButton();

        button1.addActionListener(button);

        textField1 = new JTextField();//no need to declare any other JTextField object just initialize the above crated 
        textArea1 = new JTextArea(10, 50);//same here
        JScrollPane scrollBar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        textField1.setColumns(50);

        int numOfLines = textArea1.getLineCount();

        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.append(" Number of lines: " + numOfLines);

        panel.add(label1);
        panel.add(button1);
        panel.add(textField1);
        panel.add(scrollBar1);

        this.add(panel);
        this.setLocation(xPos, yPos);
        this.setResizable(false);
        this.setTitle("Translation Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        textField1.requestFocus();

    }

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        new InClass1Main().textArea1.setText(textField1.getText());
        new InClass1Main().textField1.setText(null);
        }

    }