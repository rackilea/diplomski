public class TestBlinkingText {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new BlinkPane());
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }            
        });
    }

    protected static class BlinkPane extends JLabel {

        private JLabel label;
        private boolean state;

        public BlinkPane() {

            label = new JLabel("Look at me!");
            setLayout(new GridBagLayout());

            add(label);

            Timer timer = new Timer(500, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {                    
                    state = !state;
                    if (state) {
                        label.setForeground(Color.RED);
                    } else {
                        label.setForeground(Color.BLACK);
                    }                    
                    repaint();                    
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.setInitialDelay(0);
            timer.start();            
        }        
    }    
}