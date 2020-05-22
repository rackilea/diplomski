public class KRListener implements ActionListener {

    private MyPanel panel;

    KRListener(MyPanel panel) {
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         panel.circleZ = !panel.circleZ;
         panel.repaint();
    }
}