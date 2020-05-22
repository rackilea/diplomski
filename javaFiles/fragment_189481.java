private static char[] checkForJ(String encodeInput){
    return encodeInput.toLowerCase()
                      .replace(' ','-')
                      .replace('j','i')
                      .toCharArray();
}