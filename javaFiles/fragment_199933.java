public class Test {
//Names of the fields, you actually need to know them.
public static final String FIRST_INT_INDENTIFIER = "firstInt";
public static final String SECOND_INT_INDENTIFIER = "secondInt";
public static final String FIRST_STRING_INDENTIFIER = "firstString";

public static void main(String[] args) {

    TestObject[] testArray = new TestObject[10];

    //Fill the array with some objects.
    for (int i = 0; i < testArray.length; i++) {
        testArray[i] = new TestObject(i, i * 2, "Number: " + i);

        if (i % 3 == 0) {
            testArray[i] = new TestObject(i, i * 2, null);
        }
    }

    //Check the array of our objects.
    for (int i = 0; i < testArray.length; i++) {
        try {
            testArray[i].checkForNulls(FIRST_INT_INDENTIFIER, FIRST_STRING_INDENTIFIER);
        } catch (Exception e) {
            //Some exception handling
        }
    }

}
}