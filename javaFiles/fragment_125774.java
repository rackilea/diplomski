import java.util.Random;


public final class Test {

  public static final void main(String... aArgs){

      int arrayOfBoxes [][] = new int [10000][3];

      //if you like to use a range
       int START = 1;
       int END = 10000;


      for (int i=0;i<10000;i++)
      {

           Random randomHeight = new Random();
           Random randomWidth = new Random();
           int width = GenerateRandomInteger(START, END, randomHeight);
           int height = GenerateRandomInteger(START, END, randomWidth);


           arrayOfBoxes[i][0] = i ;
           arrayOfBoxes[i][1] = width ;
           arrayOfBoxes[i][2] = height ;

      }
      for (int k=0;k<10000;k++){
          System.out.println("Box #"+ arrayOfBoxes[k][0]);

              System.out.println("Width = " + arrayOfBoxes[k][1]);
              System.out.println("Height = " + arrayOfBoxes[k][2]);

      }

  }  


  private static int GenerateRandomInteger(int aStart, int aEnd, Random aRandom){
    if (aStart > aEnd) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    //get the range, casting to long to avoid overflow problems
    long range = (long)aEnd - (long)aStart + 1;
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long)(range * aRandom.nextDouble());
    int randomNumber =  (int)(fraction + aStart);    
    return randomNumber;
  }
}