public class sample{

public static void main(String args[]){

    // Do your part of code here

    String sampleWord = "hello";
    int individualWordSum = countSum(sampleWord);

}

public static int countSum(String word){

  String input = word.toLowerCase();
  int sum = 0;

  for( int i = 0; i < input.length()/2; i++) {
      int s = (input.charAt(i) - 'a') - (input.charAt(input.length() - 1 - i) - 'a');
      sum += Math.abs(s);
  }

  if(input.length()%2!=0){
    sum += input.charAt(input.length()/2) - 'a' + 1;
  }

  System.out.println("sum for " + input + " is " + sum);

  return sum;
 }
}