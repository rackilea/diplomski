public class ShuffleTest2 {

  public static void main(String[] args) {
    int M = Integer.parseInt(args[0]);
    int N = Integer.parseInt(args[1]); 
    int [] deck = new int [M];

    int [][] a = new int [M][M]; 

    for (int i = 0; i < M; i++) {  //initialize a to all zeroes
      for (int j = 0; j < M; j++) {
        a[i][j] = 0 ; 
      }
    }

    for(int i = 0; i < N; i++)   //puts the deck in order, shuffles it, and records. N times
    {
        for (int j = 0; j < M; j++)  //order the deck
          deck[j] = j;

        for(int j = 0; j < M; j++) {       //shuffle the deck (same as yours except counter name)
          int r = j + (int)(Math.random() * (M-j));
          int t = deck[r];
          deck[r] = deck[j];
          deck[j] = t;
        }

       for(int j = 0; j < M; j++)   //record status of this deck as described
       {
           int card_at_j = deck[j];  //value of card in position j
           a[card_at_j][j]++;        //tally that card_at_j occured in position j
       }
    }  //big loop ended

    for (int b = 0; b < M; b++)  //print loop.  a is MxM, so limit of N was wrong.
    {
        for (int c = 0; c < M; c++)
        {
           System.out.print(" " + a[b][c]);
           System.out.println();
        }
    }  //print loop ended
  }  //main() ended
 } //class ended