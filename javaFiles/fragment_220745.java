public static boolean getCharResults(String newNumString,int getLength){
        //Recreate a character array
        char [] myCharacters=newNumString.toCharArray();
        boolean doesContainLetter=false;
        int j;
        for (j=0;j<getLength;j++){
            //Tests if character is a digit
            if ((Character.isDigit(myCharacters[j])==true)){
                doesContainLetter=false;
            }
            //Tests if character is an illegal character and prints out the required error message
            else if((Character.isLetterOrDigit(myCharacters[j])==false)){
                System.out.println("Error!"+"\t"+newNumString+" contains illegal characters. Any invalid character will be set to zero.");
                doesContainLetter=true;
                return doesContainLetter;
            }
            //Test if the character is a letter
            else{
                doesContainLetter=true;
                return doesContainLetter;
            }
        }
        return doesContainLetter;
}