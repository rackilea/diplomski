for (int i = 0; i < wordsList[0].length(); i++) {
    wCharLetter = wChar[i];
    inputChar = input.next().charAt(0);
    if (inputChar == wCharLetter) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
}