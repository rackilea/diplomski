public class Losujliczbe {

    private int zmienna;

    // Method for obtain a number between [0 - 49].

    public Losujliczbe(int z) {         
        this.zmienna=z;
    }

    public int[] getLiczbe() {
        int arr[] = new int[zmienna];
        for(int i=0; i < zmienna; i++) {
            int random = (int)(Math.random() * 49 + 1);
            arr[i]=random;                           
        }
        return arr;
    }

    public static void main( String args[] ) {
        Losujliczbe br = new Losujliczbe(3); // 3 or any number for the default arg constructor
        int[] arr = br.getLiczbe();
    }
}