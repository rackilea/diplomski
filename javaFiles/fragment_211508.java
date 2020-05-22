String i = "[10] begin0-1-selp-2-yelp-25-jelp-21-hi-35-ou";
String final_string = "";

// Split the String with space to remove the first portion which
// might be indicating the line number or something like that.
String[] splittedArray = i.split(" ");

// Then just run the loop in the second item of the split
// `String` array.

int contCount = 0;
for (int j = 0; j < splittedArray[1].length(); j++) {
    char myChar = splittedArray[1].charAt(j);
    if (Character.isDigit(myChar)) {
        contCount = 0;
        final_string = final_string.concat(Character.toString(myChar));
    } else {
        if (contCount == 0)
            final_string = final_string + " ";

        contCount++;
    }
}

System.out.println(final_string);