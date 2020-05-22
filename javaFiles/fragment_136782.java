public class Answer{

    public double d;
    public int array;

    Answer(double d, boolean inFirstArray){
      if inFirstArray{
        this.d = d;
        this.int = 1;
      }
      else{
        this.d = d;
        this.int = 2;
      }
    }



}



public Answer findLargestNumber(double[] a1, double[] a2){

  boolean inFirstArray = true;
  double biggestNumber = 0;

  for (double d : a1){
    if (d > biggestNumber)
      biggestNumber = d;
  }

  for (double d : a2){
    if (d > biggestNumber){
      biggestNumber = d;
      inFirstArray = false;
    }
  } 

  Answer answer = new Anwser(biggestNumber,inFirstArray);
  return answer;  
}