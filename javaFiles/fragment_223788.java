public static String removeDiacriticsFromUppercaseLetters(String input) 
{ 
    if (input == null) 
        return null; 

    String normalized = Normalizer.normalize(input, Normalizer.Form.NFD); 

    StringBuilder newString = new StringBuilder(); 
    boolean checkDiacritics = false;

    for (int i = 0; i < normalized.length(); ++i) 
    { 
        char ch = normalized.charAt(i);

        if (checkDiacritics)
        {
            if (Character.getType(ch) == Character.NON_SPACING_MARK)
                continue;

            checkDiacritics = false;
        }

        if (Character.isUpperCase(ch))
            checkDiacritics = true;

        newString.append(ch); 
    } 

    //return newString.toString(); 
    return Normalizer.normalize(newString.toString(), Normalizer.Form.NFC); 
}