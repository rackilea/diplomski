String[] arrayOfStrings = {"abcde", "fghij", "klmnopqrs"};
// first string is long 5, need to be 9
// second string long 5, need to be 9
// third string long 9, that's ok.

String totalString = ""; // initialization of the total string
for(int i = 0; i < arrayOfStrings.length; i++){
    String piece = arrayOfString[i];

    String toBeAdded = "";
    if(piece.length() < 9){
        int length = piece.length();
        toBeAdded = piece;
        while(length < 9){
            toBeAdded = " " + toBeAdded;
            length++;
        }
    } else if(piece.length() > 9){
        throw new IllegalArgumentException ("Error, string longer than 9");
    } else {
        toBeAdded = piece;
    }
    totalString = totalString + toBeAdded;
}

System.out.println(totalString); // this will be "    abcde    fghijklmnopqrs"

// to separate the strings to as the previous example but before adding in the new array you have to remove the white spaces using>
String thisIsTheOneWithoutWhiteSpaces = pieceWithSpaces.trim();