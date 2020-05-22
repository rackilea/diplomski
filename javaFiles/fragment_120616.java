public class MainFrame extends JFrame{
    public void MainFrame() {
        setTitle("Game");
        setSize(1300, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        Dice diceObject = new Dice();
        add(diceObject);
        setVisible(true);
    }
}