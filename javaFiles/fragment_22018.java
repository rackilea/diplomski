public class MyLabel extends JLabel implements MouseListener {
    public MyLabel() {
        addMouseListener(this);
    }
    public MyLabel(String txt) {
        super(txt);
        addMouseListener(this);
    }
    public void mouseClicked(MouseEvent e) {
        System.out.println(getText() + " clicked");
    }
    public void mouseEntered(MouseEvent e) {
        setFont(new Font("tahoma", Font.BOLD, 12));
    }
    public void mouseExited(MouseEvent e) {
        setFont(new Font("tahoma", Font.PLAIN, 11));
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
}