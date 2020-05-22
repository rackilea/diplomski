import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardExample {

private Hand playHand;
private Deck playDeck;
private Scanner reader = new Scanner(System.in);  // Reading from System.in


public static void main(String args[]) {
    new CardExample().play();
}

public void play(){
    playDeck = new Deck();
    playDeck.shuffle();

    Card firstCard = playDeck.getRandomCard();
    Card secondCard = playDeck.getRandomCard();

    List<Card> startCards = new ArrayList<>();
    startCards.add(firstCard);
    startCards.add(secondCard);

    playHand = new Hand(startCards);
    requestInput();
}

private void requestInput(){
    System.out.println("You have " + playHand.getPoints() + " points");
    System.out.println("New card? (Y/N)");
    String input = reader.next();
    if(input.equalsIgnoreCase("y")){
        Card newCard = playDeck.getRandomCard();
        playHand.addCard(newCard);

        if(playHand.getNumberOfCards() < 5 && playHand.getPoints() < 22) {
            requestInput();
        }else if(playHand.getPoints() >= 22){
            System.out.println("You have " + playHand.getPoints() + "points. You're dead, sorry.");
            reader.close();
        } else{
            System.out.println("You have 5 cards, that's the max");
            reader.close();
        }
    }else{
        System.out.println("Your score is " + playHand.getPoints() + " points");
        reader.close();

    }
}
}