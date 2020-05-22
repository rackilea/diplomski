// declare instance fields before constructor
// both variables are reachable by showScore() 
private JPanel scorePanel; 
private JLabel scoreLabel;

// in constructor of your class
scorePanel = new JPanel(); // initialize the JPanel
scorePanel.setLayout(new BorderLayout()); // give it a layout

scoreLabel = new JLabel(); // initialize the label

frame.add(scorePanel); // add JPanel to your JFrame

// method obviously outside constructor
public void showScore(String username, int score)
{
    // clear the JPanel that contains the JLabel to remove it
    scorePanel.removeAll();
    scoreLabel.setText("<html>" + username + "<br/>Total Hits: " + String.valueOf(score) + "</html>");
    scorePanel.add(label, BorderLayout.CENTER);

    scorePanel.revalidate();
    scorePanel.repaint();
}