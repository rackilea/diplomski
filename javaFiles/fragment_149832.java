public static boolean hasConsecutiveCharacters(String pwd){
        String[] letter = pwd.split(""); // here you get each letter in to a string array

        for(int i=0; i<letter.length-2; i++){
            if(letter[i].equals(letter[i+1]) && letter[i+1].equals(letter[i+2])){
                return true; //return true as it has 3 consecutive same character
            }
        }
        return false; //If you reach here that means there are no 3 consecutive characters therefore return false.
    }