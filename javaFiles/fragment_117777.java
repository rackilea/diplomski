JFrame frame = new JFrame("Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);

        JPanel jp = new JPanel();
        frame.add(jp);
        jp.add(new JLabel(new ImageIcon("d:\\temp\\me.JPG")));

        frame.pack();