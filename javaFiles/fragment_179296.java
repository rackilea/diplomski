public class twerk implements ActionListener{
public void twerk() {
    button.addActionListener(this);
// omitted
}

public void actionPerformed(ActionEvent e) {
    JButton tmp = (JButton)e.getSource();
    if(tmp == button)
        au.player.stop();
}