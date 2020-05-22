Scanner in = new Scanner(System.in);
String word = "";
StringBuilder encrypedWordSB = new StringBuilder();

System.out.println("What word do you want to encrypt");
word = in.nextLine();

// Encrypt word
for (int i = 0; i < word.length(); i++) {
    char ch = word.charAt(i);
    ch++;

    encrypedWordSB.append(ch);
}

System.out.println(encrypedWordSB);