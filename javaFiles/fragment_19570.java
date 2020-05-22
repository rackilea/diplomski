public class CreateWordArray {
    static String[]  lyrics = {"Line number one", "Line number two"}; 
    static String[][] words = new String[lyrics.length][];

    public static void createWordArray() {
        for(int i=0; i<lyrics.length; i++) {
                words[i] = lyrics[i].split("\\s+");
        }
    }

   public static void main(String[] s) {

       createWordArray();
       System.out.println(Arrays.deepToString(words));

   }
}