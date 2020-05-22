public static void main(String[] args) {

    int sumaA = 1000;
    int sumaB = 0;

    Random rand = new Random();
    int n = rand.nextInt(9);
    int g = rand.nextInt(49);

    int runCounter = 0;

    while (sumaA > sumaB) {
        runCounter++;
        System.out.println("Loop run number " + runCounter);
        System.out.println("Random N = " + n);

        sumaA += n;
        System.out.println("sumaA: " + sumaA);
        System.out.println();

        System.out.println("Random N= " + g);
        sumaB += g;
        System.out.println("sumaB: " + sumaB);
    }

    System.out.println("loop ran " + runCounter + " times");
    System.out.println("value sumaA" + sumaA + "value sumaB " + sumaB);
}