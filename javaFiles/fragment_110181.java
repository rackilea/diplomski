public class Main {
    public static void main(String[]args) {
        String source = "TCGAATGTTGCTTATTGTTTTGAATGGGGTAGGATGACCTGCTAATTGGGGGGGGGGATGATGTAG";
        Matcher m = Pattern.compile("(?=(ATG((?!ATG)[ATGC]{3})*(TAA|TAG|TGA)))").matcher(source);
        System.out.println("source : "+source+"\nmatches:");
        while(m.find()) {
            System.out.print("         ");
            for(int i = 0; i < m.start(); i++) {
                System.out.print(" ");
            }
            System.out.println(m.group(1));
        }
    }
}