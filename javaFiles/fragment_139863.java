class Aufgabe {

    private static final double CONVERSION_FACTOR = 0.10197;

    // Newton in Kilopond
    static double newton(double e) {
        double newton = e * CONVERSION_FACTOR;
        return newton;
    }

    // Kilopond in Newton
    static double kilopond(double f) {
        double kilopond = f / CONVERSION_FACTOR;
        return kilopond;
    }

    // method readin
    static double[] readin() {
        String a = JOptionPane.showInputDialog("newton:");
        String b = JOptionPane.showInputDialog("kilopond:");
        double n = Double.parseDouble(a);
        double k = Double.parseDouble(b);
        return new double[] { n, k };
    }

    // Main-Methode
    public static void main(String[] args) {
        double[] valuesRead = readin();
        double a = valuesRead[0];
        double b = valuesRead[1];
        double c = newton(a);
        double d = kilopond(b);
        System.out.println(a + " N = " + c + "kp");
        System.out.println(b + " kp = " + d + "N");
    }
}