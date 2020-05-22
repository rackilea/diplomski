public class warm4{

  public static void main(String[] args){
     double[] array1 = {1,2,3,4};
     double scale1 = 3;    
     scalarMultiply(array1, scale1);
   }

   public static void scalarMultiply(double[] array, double scale){
       for( int i=0; i<array.length; i++){
       array[i] = (array[i]) * scale; 
       System.out.print(array[i] + " ");
     }
   }
 }