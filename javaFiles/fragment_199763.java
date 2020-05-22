/**
 * The class represents a full deck of cards. 
 * Each card is represented by a Node.
 * It is initialized so each Node (card), accept the first,
 * is linked to its previous card, and each node but last, 
 * is linked to its next card in the deck.
 */
public class DoublyLinkedList<T> {

    //13 cards per suit
    String[] cardValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    //4 suits
    String[] suits = {"C", "D", "H", "S"};

    //an array to hold (references to) 4*13 Nodes. Each node represents a card
    private Node<T> nodes[] = new Node[cardValues.length * suits.length];

    public DoublyLinkedList(){

        int cardCounter = 0;

        //Iterate over all suits
        for( String suit : suits) {

            //Iterate over all cards
            for(String card : cardValues) {

                //create a Node representing a card 
                Node<T> node = new Node( suit+card ); // substitute suit+card for "real" data

                //define previous node to every node but first 
                if (cardCounter > 0) {
                    //link this node to previous one 
                    node.setPrevious(nodes[cardCounter-1]);

                    //link previous node to this one 
                    nodes[cardCounter-1].setNext(node);
                }
                //add node to array
                nodes[cardCounter] = node;

                cardCounter++;
            }
        }
    }

    public boolean isEmpty(){
        return nodes.length ==0; //no mode in array 
    }

    //add more methods / functions as needed
}