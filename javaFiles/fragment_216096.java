public class TestCard extends JFrame implements ActionListener {

CardLayout cards;
JPanel cardPanel, tabsPanel;
JButton b1, b2;

public TestCard() {
    b1= new JButton("kalam");
    b2= new JButton("gapas");
    tabsPanel = new JPanel();
    cards = new CardLayout();
    cardPanel = new JPanel();
    cardPanel.setLayout(cards);

    JPanel firstCard = new JPanel();
    firstCard.setBackground(Color.WHITE);


    JPanel secondCard = new JPanel();
    secondCard.setBackground(Color.blue);


    cardPanel.add(firstCard, "kalam");
    cardPanel.add(secondCard, "gapas");
    tabsPanel.add(b1);
    tabsPanel.add(b2);

    add(tabsPanel, BorderLayout.NORTH);
    add(cardPanel, BorderLayout.CENTER);
    b1.addActionListener(this);
    b2.addActionListener(this);
    setSize(800, 600);

    cards.show(cardPanel, "gapas");
    setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().matches("kalam")) {
        cards.show(cardPanel, "kalam");
        System.out.println("kalam");
    } else {
        cards.show(cardPanel, "gapas");
        System.out.println("gapas");
    }
}
public static void main(String[] args) {
    new TestCard();
}
}