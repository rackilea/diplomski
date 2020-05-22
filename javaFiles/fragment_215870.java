String suit;  
String rank;     
int a;  
int b;
int getCard;
int getSuit;

public Card(){    
    String [] xSuit = {"Clubs","Diamonds","Hearts","Spades"};  
    // xRank array removed because I don't think you need it anymore. 
    a = ((int)(Math.random() * 4));  
    b = ((int)(Math.random() * 13) + 1);  
    suit = xSuit[a];
    switch(b) {
        case 1:
            rank = "Ace";
            break;
        case 11:
            rank = "Jack";
            break;
        case 12:
            rank = "Queen";
            break;
        case 13:
            rank = "King";
            break;
        default:
            rank = Integer.toString(a);
            break;
    }
} 

int getCard(){    
    return b;  // this will probably be unnecessary now, you'd probably also want a better name for this numeric card value...
}