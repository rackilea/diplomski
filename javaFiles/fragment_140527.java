please find the below example: 


public class Triangle{

    public static String[] quickSort(String[] givenArray, int left, int right)
    {
        int l = left;
        int r = right;
        //used to temporarily hold values for swapping process
        String temp;
        //arbitrarily picking a pivot point since I know the how much the array holds...
        String pivot = givenArray[right];
        while (l<=r)
        {
            while (givenArray[l].compareTo(pivot) < 0)
            {
                l++;
            }
            while (givenArray[r].compareTo(pivot) > 0)
            {
                r--;
            }      
            if (l <= r)
            {
                temp = givenArray[l];
                givenArray[l] = givenArray[r];
                givenArray[r] = temp;
                l++;
                r--;
            }
        }
        if (left < r)
        {
            quickSort(givenArray, left, r);
        }
        if (l < right)
        {
            quickSort(givenArray, l, right);
        }

        return givenArray;
    }

    public static void main (String arg[]){
        String[] givenArray = new String[]{"X","E","C","A"};
        printArray(quickSort(givenArray,0,givenArray.length-1));
    }

    public static void printArray(String[] sorted){
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");

        }
    }
}