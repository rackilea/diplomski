private Random r = new Random();
public static int DC(int card){
    //fields
    int cards[];
    int a;
    cards = new int[30];
    //Populate card array with random values
    for (int i=0; i < cards.length; i++){
        cards[i] = (int)(Math.random()*13)+1;
    }
    //select a random value from cards array
    a = r.nextInt(cards.length);
    return a;
}