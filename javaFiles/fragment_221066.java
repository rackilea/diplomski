public static void main(String[] args) {
    String cyphertext = "aVaqrprzoreoeratraWhyvhfraJnygreUbyynaqreqrgjrroebrefinaRqvguZnetbganneNzfgreqnzNaarjvytenntzrrxbzraznnezbrgabtrrarragvwqwrovwbznoyvwiraBznmnyurgzbrvyvwxuroorabzNaarabtrracnnejrxraqnnegrubhqrafpuevwsgRqvguSenaxvarraoevrsnnaTregehqAnhznaauhaiebrtrerohhezrvfwrvaSenaxshegnzZnva";
    char[] plaintext = new char[cyphertext.length()];

    // first shift
    shiftLetters(cyphertext, plaintext, 1);
    // update cyphertext with the intermediate result
    cyphertext = new String(plaintext);
    // second shift
    shiftLetters(cyphertext, plaintext, 2);
    // print result
    System.out.println(new String(plaintext));

}

private static void shiftLetters(String cyphertext, char[] plaintext, int shifts) {
    for (int i=0; i<cyphertext.length(); i++){
        int tmp = cyphertext.charAt(i) + shifts;
        tmp = handleEdgeCases(tmp);
        plaintext[i] = (char)(tmp);
    }
}

// here we handle the "circular" cases
private static int handleEdgeCases(int tmp) {
    if (tmp > 90 && tmp < 97) {
        tmp = tmp - 90 + 65;
    } else if (tmp > 122) {
        tmp = tmp - 122 + 97;
    }
    return tmp;
}