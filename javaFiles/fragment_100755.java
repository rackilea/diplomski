public class WaitForInput {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame=new JFrame("Example");
            JTextArea ta=new JTextArea(20,40);
            ta.setEditable(false);
            frame.setContentPane(new JScrollPane(ta));
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            char result = waitForInput(ta, "Press Y or N",
                ch -> Character.toUpperCase(ch)=='Y' || Character.toUpperCase(ch)=='N');
            waitForInput(ta,
                "You pressed "+result+", press Enter to continue", ch -> ch==10);
            ta.append("Ok, I'm happy... Close window to quit");
        });
    }
    static char waitForInput(JTextArea ta, String message, IntPredicate p) {
        ta.append(message);
        ta.append("\n");
        SecondaryLoop loop = ta.getToolkit().getSystemEventQueue().createSecondaryLoop();
        final class WaitOp extends KeyAdapter {
            char actualChar;
            public void keyTyped(KeyEvent e) {
                if(p.test(e.getKeyChar())) {
                    actualChar=e.getKeyChar();
                    loop.exit();
                }
            }
        }
        WaitOp op = new WaitOp();
        ta.addKeyListener(op);
        loop.enter();
        ta.removeKeyListener(op);
        return op.actualChar;
    }
}