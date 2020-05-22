public class JavaApplication2 extends JFrame {

private JPanel mainPanel, cpOne, cpTwo;
private JButton btnContine, btnGoBack;
private CardLayout c1;

public JavaApplication2()
{
    super("Card Layout");
    mainPanel = new JPanel(new CardLayout());
    mainPanel.add(cardOne(), "card1");
    mainPanel.add(cardTwo(), "card2");
    c1 = (CardLayout) (mainPanel.getLayout());
    add(mainPanel);
    setSize(200,200);
    setVisible(true);


    btnContine.addActionListener((ActionEvent e) -> {
        c1.show(mainPanel,"card2");
    });
    btnGoBack.addActionListener((ActionEvent e) -> {
        c1.show(mainPanel,"card1");
    });
}

private JPanel cardOne()
{
    cpOne = new JPanel();
    btnContine = new JButton("Next Panel");
    cpOne.add(btnContine);
    cpOne.add(new JLabel("First Panel"));
    return cpOne;
}
 private JPanel cardTwo()
{
    cpTwo = new JPanel();
    btnGoBack = new JButton("Previous Panel");
    cpTwo.add(btnGoBack);
    cpTwo.add(new JLabel("SECOND PANEL!!!"));
    return cpTwo;
}
public static void main(String[] args) {

    JavaApplication2 jp = new JavaApplication2();
}

}