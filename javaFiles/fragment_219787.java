String myAlteredText = "";
Scanner scanner = new Scanner(myText);

while(scanner.hasNext()) {
    String next = scanner.next();
    if(next.equals(userFindInput)) {
        myAlteredText += userReplaceInput;
    }
    else {
        myAlteredText += next;
    }
    myAlteredText += " ";
}