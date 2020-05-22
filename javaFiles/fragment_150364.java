public double toString(int p, int q) {
    double result = 0;
    if (p > 3 && q < 25) {
        if (p > 50) {
            result = p / q;
            System.out.println("p/q=" + result);
        } else {
            result = p + q;
            System.out.println("p+q=" + result);
        }
        if (q < 12) {
            result = p * q;
            System.out.println("p*q=" + result);
        } else {
            result = Math.sqrt(p * q);
            System.out.println("sqrt(p*q)=" + result);
        }
    } else {
        result = p - q;
        System.out.println("p-q=" + result);
    }
    return result;
}