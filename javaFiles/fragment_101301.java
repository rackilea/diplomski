public static String translateToEnglish(String phrase) {

    if (phrase == null)
        return null;

    boolean threeAtBeginning = false, threeAtEnd = fal;

    if (phrase.charAt(0) == '3' && phrase.charAt(1) == ' ')
        threeAtBeginning = true;      

    int length = phrase.length();

    if (phrase.charAt(length - 1) == '3' && phrase.charAt(length - 2) == ' ')
        threeAtEnd = true;

    String finished = phrase.replace('4', 'a') .replace('1', 'l') .replace('2', 'z') .replace('5', 's') .replace('8', 'b') .replace('0', 'o') .replace('7', 't') .replace("|_|", "u")  .replace("3", "e");
    finished = finished.replace(" e ", " 3 ");

    if (threeAtBeginning)
        finished = '3' + finished.substring(1);   
    if (threeAtEnd)
        finished = finished.substring(0, length - 1) + '3'; 

    return finished;
}