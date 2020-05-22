public void print(String ht) { // print array

    String st = ht.toLowerCase().replaceAll("\\s", "");
    sent = st.toCharArray();

    int[] alphabet = new int[26];
    //set all values to 0
    for(int i = 0 ; i < alphabet.length ; i++){
        alphabet[i] = 0;
    }
    //Loop through all characters and increment corresponding value
    for(int i = 0 ; i < sent.length ; i++){
        alphabet[sent[i] - 97]++;
    }
    //Print character + asterisk for each time the character is used
    for(int i = 0 ; i < alphabet.length ; i++){
        System.out.print((char)(i + 97) + ": ");
        for(int nChars = 0 ; nChars < alphabet[i] ; nChars++){
            System.out.print("*");
        }
        System.out.println();
    }

}