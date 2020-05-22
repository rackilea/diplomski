public static void main(String[] args) {
        final String chords = "ADE";
        final int N = chords.length();
        Random rand = new Random();
        char temp = 0;
        for (int i = 0; i < 50; i++) {
           char s = chords.charAt(rand.nextInt(N));
           while(s == temp){ //loop until a new character is generated, this loop will stop when s != temp
               s = chords.charAt(rand.nextInt(N));
           }
           temp = s; //assign current character to the temp variable, so on next iteration this can be compared with the new character generated.
           System.out.println(s);
        }
}