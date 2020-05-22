/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial;

import java.util.Random;

/**
 *
 * @author hezarehee
 */
public class Kortlek {

    Random r = new Random();
    /**
     * In this method we create 2D array in order to group each card color and its cards (1-13)
     */
    String cardList[][] = new String[4][13];

    // ArrayIndexOutOfBoundsException
    // String cardList[][] = new String[3][12];

    public String[][] buildCardGame () {
        String[] farg = {"Spader", "Hjarter", "Ruter", "Klover"};
        String[] nummer = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "Ace"};


        for (int i=0; i < farg.length; i++) {
            for (int j=0; j < nummer.length; j++) {
                cardList[i][j] = farg[i] + " " + nummer[j];
            }

        }
        return cardList;
    }

    /**
     * Here we make a method that let computer to choose a name from given names in array
     */
    public String nickNamePC () {
        String[] nickName = {"Daivd", "Rahim", "Michael", "Sara", "Marie", "Jenny"};

        int low = 0;
        int high = 5;
        int result =  r.nextInt(high-low) + low;
        String chosenName = nickName[result];
        return chosenName;
    }

    /**
     * Here we each time pick up a card from our 2D Array cardList[][] 
     */
    public String pickCard() {
        int takeColor = r.nextInt(3-1) + 1;
        int takeNumber = r.nextInt(12-1) + 1;

        // we put our random numbers into the array carDList
        String pickedCard = cardList[takeColor][takeNumber];
        return pickedCard;
    }

}