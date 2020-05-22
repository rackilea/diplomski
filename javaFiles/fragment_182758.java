public class ArrayAddition
{
public static void main(String[] args)
{
    double array1[] = {2./3, 0, -1, 0, 7./2}; // first array
    double array2[] = {0, 0, -2./3, 1, 0, 0}; // second array
    int length = Math.max(array1.length, array2.length); // length of longest array
    double newArray[] = new double[length]; // result must be length of longest array

    int index1 = array1.length - 1; // last element of first array
    int index2 = array2.length - 1; // last element of second array
    int indexRes = length - 1;      // result will be placed in last spot of result

    for (int i = length -1; i >= 0; i--) // adds elements of two arrays together bckwrd
    {

        double val1, val2;     // value holders for array elements

        try  // try to get value of the array 1 at certain position
        {
            val1 = array1[index1];
        }
        catch(ArrayIndexOutOfBoundsException e)  // if empty, make it zero
        {
          val1 = 0;
        }

        try   // try to get value of array 2 at certain position
        {
            val2 = array2[index2];
        }
        catch(ArrayIndexOutOfBoundsException e) // if empty make it zero
        {
            val2 = 0;
        }

        newArray[indexRes] = val1 + val2; // array[?] result is val1 + val 2
        index1--;  // decrement to the next lower value
        index2 --; // decrement to the next lower value
        indexRes--; // go the next lower spot


    }

    for (int i = 0; i < newArray.length; i ++)  // this loop prints out the results
        System.out.println(newArray[i]);

}

}