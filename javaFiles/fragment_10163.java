class Main {
    public static void niceround(double x) {
        System.out.println(x+" to " + Math.ceil(x * Math.pow(10, -Math.floor(Math.log10(x)))) / Math.pow(10, -Math.floor(Math.log10(x))));
    }
    public static void main(String[] args) {
        niceround(0.0322);
        niceround(3.22);
        niceround(32.2);
        niceround(42.2);
        niceround(422.2);
    }
}