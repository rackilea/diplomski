class Frame1 extends JFrame {
    private JLabel idLabel;
    public Frame1() {
        .........
        gotoSecondFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idLabel.getText());// just get id value from jlabel
                JFrame2 frame = new JFram2(id);// then pass to second jframe
                frame.setVisible(true);// show second jframe
            }
        });
        ........
    }
}

class Frame2 extends JFrame {
    private void query(int id) {
        .......
    }
    public Frame2(int id) {
        .......
        query(id);// your query with id which passed from first jframe
        .......
    }
}