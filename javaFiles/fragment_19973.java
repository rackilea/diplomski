public static void main(String[] args) 
    {
            //elements to be shown in the combo box
        String course[] = {"", "A", "B", "C"};

        JFrame frame = new JFrame("Creating a JComboBox Component");
        JPanel panel = new JPanel();

        JComboBox combo = new JComboBox(course);

        final JButton button = new JButton("Save");
        panel.add(combo);
        panel.add(button);

            //disables the button at the start
        button.setEnabled(false);
        frame.add(panel);

        combo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                            //enables the button when an item is selected
                button.setEnabled(true);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }