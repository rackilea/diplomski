String text = toLower; //if toLower is not correct, use a correct variable to get the data to encrypt from.
        String encrypt = "";

    for (int i = 0; i <text.length(); i++) {
        char c = text.charAt(i);
        if ((Character.isLetter(c))) {

       encrypt += (char)((int)c + 5);

        }  
    }


   return encrypt;