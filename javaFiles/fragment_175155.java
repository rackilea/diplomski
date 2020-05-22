package unoGame;

import java.util.Random;

public class Driver {
    public static unoDeck theDeck = new unoDeck();
    public static PlayerHand[] thePlayers;
    public static DiscardPile dp = new DiscardPile();
    public static int nextPlayer;
    public static Random getRandom = new Random();

    public static void main(String[] args) {
        thePlayers = new PlayerHand[3];
        thePlayers[0] = new PlayerHand("name 1");
        thePlayers[1] = new PlayerHand("name 2");
        thePlayers[2] = new PlayerHand("name 3");

        theDeck.shuffle();
        System.out.println("Here is the Deck:  " + theDeck);

        System.out.println(" Welcome to UNO! ");

        if (dp.isEmpty()) {
            System.out.println(" Discard is Empty ");
        }
        else {
            System.out.println(" Not Empty ");
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < thePlayers.length; j++) {
                thePlayers[j].addCard(theDeck.deal());
            }
        }
        nextPlayer = 0;
        showPlayers();

        dp.addCard(theDeck.deal());

        while (checkForWin() == false) {
            findNextPlayer();

            if (theDeck.isEmpty()) {
                theDeck.replenish(dp.clear());
            }
            playerTurn();
        }
        System.out.println(thePlayers[nextPlayer].getName() + " Wins!");
    }

    public static void showPlayers() {
        for (PlayerHand p : thePlayers)
            System.out.println(p);
    }

    public static boolean checkForWin() {
        boolean win = false;
        if (thePlayers[nextPlayer].isWin()) {
            win = true;
        }
        return win;
    }

    public static void findNextPlayer() {
        nextPlayer++;
        nextPlayer = nextPlayer % thePlayers.length;
        if (dp.getTopCard().getValue() == "SK") {
            nextPlayer++;
            nextPlayer = nextPlayer % thePlayers.length;
        }
        if (dp.getTopCard().getValue() == "D2") {
            for (int i = 0; i <= 1; i++) {
                thePlayers[nextPlayer].addCard(theDeck.deal());
            }
        }
        if (dp.getTopCard().getValue() == "W4") {
            for (int i = 0; i <= 3; i++) {
                thePlayers[nextPlayer].addCard(theDeck.deal());
            }
        }
        if (dp.getTopCard().getValue() == "RV") {
            for (int i = 0; i < thePlayers.length / 2; i++) {
                PlayerHand rev = thePlayers[i];
                thePlayers[i] = thePlayers[thePlayers.length - i - 1];
                rev = thePlayers[thePlayers.length - i - 1];
                if (nextPlayer == 0) {
                    nextPlayer = 0;
                }
                if (nextPlayer == 2) {
                    nextPlayer = 1;
                }
            }
            nextPlayer++;
        }
    }

    public static void playerTurn() {
        if (thePlayers[nextPlayer].hasMatch(dp.getTopCard())) {
            System.out.println(thePlayers[nextPlayer].getName() + " has a match!");
            unoCard c = thePlayers[nextPlayer].playCard(dp.getTopCard());
            dp.addCard(c);
            if(c.getValue().equals("W")) {
                c.setColor(theDeck.newColor());
            }
            if(c.getValue().equals("W4")) {
                c.setColor(theDeck.newColor());
            }
            System.out.println(thePlayers[nextPlayer].getName() + " played a: " + dp.getTopCard());
            System.out.println(thePlayers[nextPlayer]);
        }
        else {
            unoCard c = theDeck.deal();
            thePlayers[nextPlayer].addCard(c);
            System.out.println(thePlayers[nextPlayer].getName() + " drew a: " + c);
        }
    }
}