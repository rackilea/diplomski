public class TestReadMultiDimensionArray {

private int[] startPosition;                //Start position.
private int[] endPosition;                  //End position.
private boolean inRange = false;            //If the current position is in range.
private List<Object> result;                //List to store the values we find.

public TestReadMultiDimensionArray() {
    result = new ArrayList<>();
}

public static void main(String[] args) {
    TestReadMultiDimensionArray test = new TestReadMultiDimensionArray();
    Integer[][][][] testSubject = new Integer[2][2][4][];
    //(0,0,y,z)
    testSubject[0][0][0] = new Integer[]{1};                                    //(0,0,0,0)
    testSubject[0][0][1] = new Integer[]{2};                                    //(0,0,1,0)
    testSubject[0][0][2] = new Integer[]{3};                                    //(0,0,2,0)
    testSubject[0][0][3] = new Integer[]{4};                                    //(0,0,3,0)
    //(0,1,y,z)
    testSubject[0][1][0] = new Integer[]{5};                                    //(0,1,0,0)
    testSubject[0][1][1] = new Integer[]{6};                                    //(0,1,1,0)
    testSubject[0][1][2] = new Integer[]{7, 8, 9};                              //(0,1,2,0) (0,1,2,1) (0,1,2,2)
    testSubject[0][1][3] = new Integer[]{10};                                   //(0,1,3,0)
    //(1,0,y,z)
    testSubject[1][0][0] = new Integer[]{11, 12};                               //(1,0,0,0)..
    testSubject[1][0][1] = new Integer[]{13, 14, 15};
    testSubject[1][0][2] = new Integer[]{16, 17, 18};
    testSubject[1][0][3] = new Integer[]{19, 20, 21};                           //..(1,0,3,2)
    //(1,1,y,z)
    testSubject[1][1][0] = new Integer[]{22, 23};                               //(1,1,0,0)..
    testSubject[1][1][1] = new Integer[]{24, 25, 26};
    testSubject[1][1][2] = new Integer[]{27, 28, 29, 30, 31, 32, 33, 34};
    testSubject[1][1][3] = new Integer[]{35, 36};                               //..(1,1,3,1)
    //Launch the test.
    test.readValue(testSubject);
}

/**
 *
 * @param obj The Array from where we want to get the data.
 */
public void readValue(Object obj) {
    //Where should it start.
    startPosition = new int[]{0, 1, 0, 0};
    //Where should it stop.
    endPosition = new int[]{1, 1, 1, 2};
    System.out.println("Start Position:" + Arrays.toString(startPosition) + " End Position:" + Arrays.toString(endPosition));
    int[] currentPosition = new int[]{-1, -1, -1, -1};

    //Call to the method.
    testRead((Object[]) obj, 0, currentPosition);
    //Result to array.
    Object[] arrayToReturn = result.toArray(new Object[0]);
    System.out.println("Result: " + Arrays.toString(arrayToReturn));
}

/**
 * Recursive method that looks for the values in a multi-dimensional array, in a given range. /!\ No checks are implemented here, wrong input can end in a
 * StackOverFlow.
 *
 * @param obj The array in Object[] form.
 * @param currentDimension The dimension we are currently in.
 * @param result The reference to the list that will store all the values we found.
 * @param currentPosition The current position we are in.
 */
private void testRead(Object[] obj, int currentDimension, int[] currentPosition) {
    for (int i = 0; i < obj.length; i++) {
        currentPosition[currentDimension] = i;
        if (Arrays.equals(startPosition, currentPosition) && currentDimension == (currentPosition.length - 1)) {
            //Found the start position.
            System.out.println("############ START ############");
            inRange = true;
        }

        if ((i >= startPosition[currentDimension] && i <= endPosition[currentDimension]) || inRange == true) {
            //We are in the write track to get to the values we are looking for.
            if (obj[i] instanceof Object[]) {
                //The data contained in the cell is an array.
                testRead((Object[]) obj[i], currentDimension + 1, currentPosition);
            } else {
                //The data contained in the cell is a scalar. This is what we where looking for.
                System.out.println(Arrays.toString(currentPosition) + " Data: " + obj[i]);
                result.add(obj[i]);
            }
        }

        if (Arrays.equals(endPosition, currentPosition) && currentDimension == (currentPosition.length - 1)) {
            //Found the end position.
            System.out.println("############ END ############");
            inRange = false;
        }
    }
}

}