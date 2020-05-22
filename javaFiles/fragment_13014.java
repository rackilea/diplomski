public class PrimeSum{

 public static void main(String[] args) {

  int[] array = new int[100];
  int[] result = new int[array.length];
  int aLength = array.length;

  for(int i = 2; i < aLength; i++){

    if(isPrime(i)){

    result[i] = i;

    System.out.println(i); // if you want you can avoid this instruction and active above "displayNonNullValueArray(result);"

 }
 } 

 //displayNonNullValueArray(result); you can also use this instruction to display your array "result"

}

// test if an integer is a prime number
static boolean isPrime(int m){

  for(int i=1; i<=m; i++){

      if(m%i==0 && i!=1 && i!=m){
         return false;
      }
  }

  return true;
   }

   //display an non-null values of an array
static void displayNonNullValueArray(int[] a){

 for(int val:a){

     if(val!=0){
         System.out.println(val);
     }
 }
}

}