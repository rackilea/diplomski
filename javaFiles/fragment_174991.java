public class CONFIGUREGAME extends JFrame implements ActionListener
{
    Jframe frame = new JFrame("...");
    public JTextField playername1 = new JTextField();
    public JButton startgame = new JButton();

    public CONFIGUREGAME()
    {
        startgame.addActionListener(this);
    }

    public static void main(String (String[] args) 
    {
       new CONFIGUREGAME();
    }

    public void actionPerformed(ActionEvent aEvt) 
    {
        if(aEvt.getSource()==startgame)
        {
            frame.dispose();
            new ROULETTETABLE(playername1.getText());
        }
    }
}

public class ROULETTETABLE extends CONFIGUREGAME implements ActionListener
{
     public JButton player1 = new JButton();

     public ROULETTETABLE(String playerName)
     {
         player1.setText(playerName);
     }

     public static void main(String (String[] args) 
     {
         new ROULETTETABLE();
     }
}