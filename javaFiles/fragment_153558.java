public class Sorter {
    private int vector; \\ private just means only things inside this class can affect this variable
    // now initializer 
    public Sorter(int[] input) {
        this.vector = input; \\ set our field to be equal to the vector you input when making an instance
    // so the call to make a Sorter object will now be "Sorter sorter = new Sorter(input);"
    }

    // make this act on vector instead
    public static int[] insertionSort() // no input because it can "see" our vector field
    {
        int[] copy = this.vector; // make a copy so you don't mess vector up before your finished
        for (int i = 1; i < copy.length; i++) 
        {
            int valueToSort = copy[i];
             int j = i;

            while (j > 0 && copy[j - 1] > valueToSort) 
            {
                copy[j] = copy[j - 1];
                j--;
            }//end while loop.

            // insert the element
            copy[j] = valueToSort;
        }//end for loop    

        this.vector = copy; // now replace old field with our sorted copy!
    }//end insertionSort          

    // this is an excellent way to be able to see "vector" without allowing other
    // mischievous programs to accidentally change "vector." This is very similar reasoning
    // to why you very frequently have fields be private. Read up on encapsulation - it's 
    // super useful.
    public void printArray(int[] input) 
    { 
    System.out.println(this.vector.toString());
    }