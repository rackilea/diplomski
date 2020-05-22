public static boolean hasValidDigits(String nameAccount){
    for(int i = 0; i < nameAccount.length(); i++){
        if(!(Character.isDigit(nameAccount.charAt(i)))){
            return false;
           }
       }
       return true;
    }