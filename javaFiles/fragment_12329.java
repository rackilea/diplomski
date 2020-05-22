private static boolean TestIOC(String text) {
    // Replace any character *not* in the range a-z, and change all characters to lowercase.
    String plaintext = text.toLowerCase().replaceAll("[^a-z]", "");

    //System.out.println(plaintext);

    int counts[] = new int[26];
    int totcount = 0;
    double sum = 0;
    double ic = 0;

    for (int i = 0; i < 26; i++) counts[i] = 0;
    for (int i = 0; i < plaintext.length(); i++) {
        int codePointAtI = Character.codePointAt(plaintext, i);
        //System.out.println(codePointAtI);

        counts[codePointAtI - 97]++;
        totcount++;
    }

    //System.out.println("Totcount: " + totcount);

    for (int i = 0; i < 26; i++) {
        sum = sum+counts[i]*(counts[i]-1);          
        ic = sum/(totcount*(totcount-1));
    }

    //System.out.println("Sum:" + sum);
    //System.out.println("ic: " + ic);

    if (ic >= 0.059 && ic <= 0.068) {
        System.out.println("This file contains an English text.");
        return true;
    }

    else {
        System.out.println("This file does not contain an English text.");
        return false;
    }
}