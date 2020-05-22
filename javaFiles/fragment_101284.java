String word = BIO.getString();
while (!word.equals( "END" )) {
    char[] arr = word.toCharArray();
    inorder = true;
    for (int i=0; i < arr.length-1; i++) {
        char a = Character.toLowerCase(arr[i]);       // convert both characters
        char b = Character.toLowerCase(arr[i+1]);     // to lowercase
        if (a > b) {
            inorder = false;
            break;
        }
    }

    if (inorder) {
        System.out.printf("%-10s letters in ascending order ", word);
    }
    else {
        System.out.printf("%-10s letters not in ascending order ", word);
    }
    word = BIO.getString();
}