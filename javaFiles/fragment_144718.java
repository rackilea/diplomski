public static double heatloss(double x, double m, double a) {
    double heatloss = x - m * (x - a);

    if (x < 55) {
        System.out.println("potatoe too cold");
        return /* put something here */
    }
    else {
        System.out.println(heatloss);
        x = heatloss(x,m,a);
        return /* put something here */
    }
}