public class Test {

    public static void main(String[] args){
        int[] testArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[] newArray = remove(testArray, 6);
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i]+" ");
        }
    }

    public static int[] remove(int[] originalArray, int toDelete){  
        if(toDelete == originalArray.length){
            //avoid the removal of all the elements, save at least first and last
            toDelete = originalArray.length-2;
        }
        int originalLength = originalArray.length;
        int newLength = originalLength - toDelete;
        int toChoose = newLength - 2;
        int[] newArray = new int[newLength];
        double fraction = ((double)toChoose) / ((double)originalLength -2);
        double counter = 0;
        int threshold = 1;
        int newArrayIndex = 1;
        for(int i = 1; i < originalLength-1; i++){
            counter += fraction;            
            if(((int)counter) == threshold ||
                //condition added to cope with x.99999999999999999... cases 
               (i == originalLength-2 && newArrayIndex == newLength-2)){
                newArray[newArrayIndex] = originalArray[i];
                threshold++;
                newArrayIndex++;
            }           
         }
         newArray[0] = originalArray[0];
         newArray[newArray.length-1] = originalArray[originalArray.length-1];
         return newArray;
    }
}