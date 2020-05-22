public class ButtonListener implements ActionListener {

    private Player p;

    public ButtonListener(Player p){
      this.p = p;
    }
    public void actionPerformed(ActionEvent arg0) {
        p.roll();
    }
}