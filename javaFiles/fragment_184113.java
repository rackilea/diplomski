public static void main(String[] args) {

    double x = 1, harmonic = 0, y = 2;
    List<Double> arc = new ArrayList<>();

    do {
        arc.add(x / y);
        y++;
    } while (y <= 500);

    for (Double double1 : arc) {
        harmonic += double1;
    }
    System.out.println("Harmonic sum is: " + harmonic);
}