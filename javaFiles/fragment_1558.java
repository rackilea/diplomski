String wordOne = userInputSplit[0];
String wordTwo = null;
if (userInputSplit.length > 1){
    //This line will throw an error if you try to access something 
    //outside the bounds of the array
    wordTwo = userInputSplit[1];  
}
if (wordTwo !=null) {
    System.out.println("The apple is " + wordOne + " with " + wordTwo + " dots.");
} 
else {
    System.out.println("The apple is " + wordOne + " with no colored dots.");
}