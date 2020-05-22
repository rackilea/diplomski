public class BlackJack
{   
    public static void main(String[] args) 
    {
        Interface Win = new Interface ();
    }

    public static int value(int cardID)
    //stores values for each "card ID number" 
    {

        int [] cardValue = {2, 2, 2, 2, 
                3, 3, 3, 3, 4, 4, 4, 4, 
                5, 5, 5, 5, 6, 6, 6, 6, 
                7, 7, 7, 7, 8, 8, 8, 8, 
                9, 9, 9, 9, 10, 10, 10, 10, 
                10, 10, 10, 10, 10, 10, 10, 10, 
                10, 10, 10, 10, 11, 11, 11, 11};

        return cardValue[cardID];
    }
}

class Interface extends JFrame implements ActionListener
{

    int index;
    int IDIndex = 0;

    // Add all image components here:
    ImageIcon [] cardImage = new ImageIcon[52];
    {
    for (index = 0; index <= 51; index++)
        cardImage[index] = new ImageIcon(index + ".png");

    }
    ImageIcon Empty = new ImageIcon("blank");

    //identify variables
    int cardCounter = 0;
    int dealerCardCounter = 0;
    int cardID;
    boolean Continue;

    //keeps track of cards left in the deck. 
    boolean [] cardsLeft = new boolean [52];{
    for (index = 0; index < cardsLeft.length; index++)
        cardsLeft[index] = true;
    }

    // Interface components here:
    int plyrSum = 0;
    int dealerSum = 0;
    int aceCounter = 0;
    JLabel Info = new JLabel (""); //<== this will be (setText to) either "Bust!", "Black Jack!"/"21!" or "What would you like to do?"
    JLabel PlyrCardSum = new JLabel("Sum: " + plyrSum);
    JLabel DealerCardSum = new JLabel("Dealer sum: " + dealerSum);
    JLabel winLoseLabel = new JLabel("");

    JLabel [] cardLabel = new JLabel[20];
    {
        for (index = 0; index < 20; index ++){
            cardLabel[index] = new JLabel (Empty);
        cardLabel[index].setSize(50, 50);
        }
    }

    JButton hit = new JButton ("Hit!");
    JButton stay = new JButton ("Stay");
    JButton reset = new JButton ("New Round");

    //JPanels here:
    JPanel buttons = new JPanel();
    JPanel plyrCards = new JPanel();
    JPanel dealerCards = new JPanel ();

    public Interface ()
    {

        super ("BlackJack 21");
        setSize (1000,729);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setVisible (true);

        //GridBagConstraints card = new GridBagConstraints();

        Container contentArea = getContentPane();
        contentArea.setBackground(Color.white);

        //Event listeners
        hit.addActionListener (this);
        stay.addActionListener (this);
        reset.addActionListener (this); 

        //add panels to different compass points on the content area
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        buttons.add(hit);
        buttons.add(stay);
        buttons.add(reset);
        buttons.add(PlyrCardSum);
        contentArea.setLayout(grid);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;


        contentArea.add(buttons,c);
        GridBagLayout grid1 = new GridBagLayout();
        plyrCards.setLayout(grid1);
        for (index = 0; index < 10; index ++){
            c.fill = GridBagConstraints.HORIZONTAL;

            c.gridx = index;
            c.gridy = 1;
            c.gridwidth = 1;
            plyrCards.add(cardLabel[index],c);
        }


        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 10;
        //plyrCards.setSize(new Dimension(50,50));
        contentArea.add(plyrCards,c);
        GridBagLayout grid2 = new GridBagLayout();
        dealerCards.setLayout(grid2);
        for (index = 10; index < 20; index ++){
            c.fill = GridBagConstraints.HORIZONTAL;

            c.gridx = index;
            c.gridy = 2;
            c.gridwidth = 1;
            dealerCards.add(cardLabel[index],c);
        }


        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 10;
        //plyrCards.setSize(new Dimension(50,50));
        contentArea.add(dealerCards,c);
        //contentArea.add(dealerCards,BorderLayout.SOUTH);

        //Add components to panels





    }
    public void actionPerformed(ActionEvent event) 
    {
        Random RandomNumber = new Random();
        if (event.getSource() == hit)
        {
            if (plyrSum < 21)
            {
                Continue = true;
                while (Continue == true) //Generates a new random number if that number has already been generated
                {
                    cardID = (int) RandomNumber.nextInt(51 + 1); 
                    if (cardsLeft[cardID] == true) //If a new card is drawn, continue normally
                    {
                        cardCounter++;
                        cardsLeft[cardID] = false; //save that the card was drawn
                        plyrSum += Testing.value(cardID); //add value to sum
                        Image resizedImage = cardImage[cardID].getImage();
                        resizedImage = resizedImage.getScaledInstance(100, 150, 1);
                    cardLabel[IDIndex].setIcon(new ImageIcon(resizedImage)); //Display card
                        //cardLabel[IDIndex].setIcon(cardImage[cardID]); //Display card
                        PlyrCardSum.setText("Sum: " + plyrSum);
                        IDIndex++;
                        if(cardID >= 47)
                            aceCounter++;
                        Continue = false; //Stop the loop that draws a new card

                    }

                }

            }

            if (plyrSum > 21 && aceCounter > 0) //If bust, reduce values of ace by 10 (from 11 to 1). 
            {

                    plyrSum -= 10;
                    aceCounter--;

            }

        }

        //Stay/Finish round button
        if (event.getSource() == stay)
        {

            aceCounter = 0;
            cardCounter = 10; //Starts at 10 so it will end up in the south JPanel
            while (dealerSum < 17)
            {
                cardID = (int) RandomNumber.nextInt(52);
                if (cardsLeft [cardID] == true)
                {
                    dealerSum += Testing.value(cardID);
                    cardsLeft [cardID] = false;
                    Image resizedImage = cardImage[cardID].getImage();
                        resizedImage = resizedImage.getScaledInstance(100, 150,1);
                    cardLabel[cardCounter].setIcon(new ImageIcon(resizedImage)); //Display card
                    if(cardID >= 47)
                        aceCounter++;
                    cardCounter++;


                    if (plyrSum > 21 && aceCounter > 0) //If bust, reduce values of ace by 10 (from 11 to 1). 
                    {

                        dealerSum -= 10;    
                        aceCounter--;

                    }

                }

            }

        }

        //Reset button
        if (event.getSource() == reset)
        {

            for (index = 0; index < 52; index++)
            {
                cardsLeft[index] = true;
            }

            cardCounter = 0;

        }


    }
}