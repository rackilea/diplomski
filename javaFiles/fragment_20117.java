Boolean inOrder = true;

while (inOrder ) {
    word = word.toLowerCase();
    char previous = word.charAt(0);
    for (int x = 0; x < word.length() && inOrder ; x++) {
        inOrder = word.charAt(x) >= previous;
        previous = word.charAt(x);
    }

    if (inOrder ) {
        System.out.print(word + "letters in ascending order" + "\n");
    } else if (!inOrder ) {
        System.out.print(word + "letters not in ascending order" + "\n");
    }

    System.out.print("#Please enter a word : ");
    word = BIO.getString();
}