public class HouseOfCards {

public class HouseOfCards {

public static void main(String[] args) {
    int Spades=1;
    String [] suitNames= {
            "Spades","Diamonds","Clubs","Hearts"
    };
    String [] cardNames= {
            "Ace","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"
    };
    String card1="";
    String card2="";
    String suitName="";
    String cardName1="";
    String suitName2="";
    String cardName2="";
    int cardPosition1 = 0;
    int cardPosition2 = 0;
    for (int i=0; i<=1; i++){
        int numCard=52;
        int randNum=(int)(Math.random() * numCard);
        int suitNum = randNum / 13;
        int cardNum = randNum % 13;
        if(i==0) {          
            suitName = suitNames[suitNum];
            cardName1 = cardNames[cardNum];
            card1 = cardName1+" of "+suitName;
        }
        else {
            suitName2 = suitNames[suitNum];
            cardName2 = cardNames[cardNum];
            card2 = cardName2+" of "+suitName2;
        }
    }
    System.out.println(card1);
    System.out.println(card2);

    for (int i = 0; i < cardNames.length; i++) {
        if(cardName1.equals(cardNames[i])) {
            cardPosition1 = i;
        }
        if(cardName2.equals(cardNames[i])) {
            cardPosition2 = i;
        }
    }
    System.out.println(cardPosition1);
    System.out.println(cardPosition2);
    if(cardPosition1>cardPosition2) {
        System.out.println("First card has bigger number");
    }
    else if (cardPosition1<cardPosition2) {
        System.out.println("Second card has bigger number");
    }
    else if (cardPosition1==cardPosition2) {
        System.out.println("Equal cards (probably different suites you can check it further)"); 
    }
  }
 }