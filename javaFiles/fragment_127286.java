String tableName = "aaa"; // just for the sake of testing it
String[] splittedOutput = yourOutputString.split(", ");
int valuesOnLine = 5; // EDIT
for (int i = 0; i < splittedOutput.length; i++) {
    if (i % valuesOnLine == 0) { // EDIT
        // 0 % 5 == 0, 5 % 5 == 0 etc., so we get here on every 5th element
        // which are the Px's, so we need to print the beginning of the line
        System.out.print("INSERT INTO " + tableName + " VALUES (");
    }
    System.out.print(splittedOutput[i]);
    if (i % valuesOnLine == valuesOnLine - 1) { // EDIT
        // we get here on the 4th, 9th, 14th, ... element, which means that
        // it's the last element that we'll print on that line
        System.out.println(")");
    } else {
        // if the condition above is not true, it's just some element
        // in the middle so we just print a comma and a space
        System.out.print(", ");
    }
}