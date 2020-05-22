public class Test extends JFrame{

    private JRadioButton but1, but2, but3;

    public Test(){
        setSize(new Dimension(200,200));
        initComp();
        setVisible(true);
    }

    private void initComp() {
        but1 = new JRadioButton();
        but1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                but2.setVisible(but1.isSelected());
                but3.setVisible(but1.isSelected());
            }
        });

        but2 = new JRadioButton();
        but2.setVisible(false);

        but3 = new JRadioButton();
        but3.setVisible(false);
        setLayout(new FlowLayout());

        JPanel pan = new JPanel();
        pan.add(but1);
        pan.add(but2);
        pan.add(but3);

        getContentPane().add(pan);
    }

    public static void main(String[] args) {
        new Test();
    }
}