public static int[] process(String str) {
    int[] counts = new int[25];
    for (int i=0; i<str.length(); i++){
        char letter = str.charAt(i);
        int index = Character.toLowerCase(letter-'a');
        if (index>=0 && index<26){
            counts[index]++;
        }
    }
 return counts;
}