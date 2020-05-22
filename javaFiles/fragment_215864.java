public class flipper {
    public static void main(String[] args) {
        int heads = 0;
        int count = 0;
        while (heads < 3) {
            int flip = (int)(Math.random() * 2);  // range [0, 1]
            count++;
            if (flip == 0) {
                System.out.print("H");
                heads++;
            } else {
                System.out.print("T");
                heads = 0;
            }
        }
        System.out.println("\nIt took " + count + " flips to achieve three heads in a row");
    }
}