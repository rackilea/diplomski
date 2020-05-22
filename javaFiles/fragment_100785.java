for (int i = 0; i < wordsArray.length; i++) {
    char[] eachLetterinArray = wordsArray[i].toCharArray();
    int count = 0;
    for (int j = 0; j < eachLetterinArray.length; j++) {
        if ((eachLetterinArray[j] + 'a' - 97 >= 65 && eachLetterinArray[j] + 'a' - 97 <= 90)
                || (eachLetterinArray[j] + 'a' - 97 >= 97 && eachLetterinArray[j] + 'a' - 97 <= 122)) {

            count++;
        }                
    }
    System.out.println(count);
}