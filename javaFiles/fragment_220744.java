int i;
containsLetters=getCharResults(newNumberString,length);
if (containsLetters==true){
    for (i=0;i<length;i++){
        //Resets area code to 0 if a character is invalid (aka !@#$%^&* and so on)
        if((Character.isLetterOrDigit(myCharacters [i]))==false){
            areacode=0;
        }
        //Converts every character to a number (stored as a character)
        myCharacters [i]=convertLetNum((myCharacters [i]));
        //Recreates the string in all-number format
        reNewNumber=reNewNumber+myCharacters[i];
            }
    }
    number=Integer.parseInt(reNewNumber);
}