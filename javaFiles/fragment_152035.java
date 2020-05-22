import java.util.Arrays;
    import org.apache.commons.lang.ArrayUtils;

     ....
    //let's create an array for demonstration purpose
    int[] test = new int[] { 101, 102, 103, 104, 105};

    System.out.println("Original Array : size : "
                           + test.length );
    System.out.println("Contents : " + Arrays.toString(test));

    // let's remove or delete an element from an Array
    // using Apache Commons ArrayUtils
    test = ArrayUtils.remove(test, 2); //removing element at index 2

    // Size of an array must be 1 less than the original array
    // after deleting an element
    System.out.println("Size of the array after
              removing an element  : " + test.length);
    System.out.println("Content of Array after
             removing an object : " + Arrays.toString(test));