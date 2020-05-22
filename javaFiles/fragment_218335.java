public class GUITest {

    // ***** So move it to where it now does  belong
    public static void main(String[] args){
        final JFrame f=new JFrame();
        f.setLayout(new BorderLayout());
        f.add(new PatternPanel());
        f.setSize(500,500);
        f.setVisible(true);
        f.setBackground(Color.CYAN);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton b1 = new JButton("change color");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.setLayout(new BorderLayout());
                f.add(new CircleTile());
                f.setSize(500,500);
                f.setVisible(true);
                f.setBackground(Color.CYAN);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                repaint();
            }
        });
        ;
        buttonPanel.add(b1);
        f.add(buttonPanel,BorderLayout.SOUTH);
    }    

    static class buttonlistener implements ActionListener {
        JFrame l1 ;
        buttonlistener(JFrame l1) {
            this.l1 = l1;
        }

        protected void repaint() {
            // TODO Auto-generated method stub
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
        }   
    }
}