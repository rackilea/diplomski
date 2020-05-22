public static void main(String... args) {
    double[] values = {0.43678436287643872, 0.4323424556455654, 0.6575643254344554,
            -0.43678436287643872, -0.4323424556455654, -0.6575643254344554,
            -0.6575699999999999 };

    for (double v : values) 
        System.out.println(v + " => "+roundDown5(v));
}

public static double roundDown5(double d) {
    return ((long)(d * 1e5)) / 1e5;
    //Long typecast will remove the decimals
}

// Or this. Slightly slower, but faster than creating objects. ;)
public static double roundDown5(double d) {
    return Math.floor(d * 1e5) / 1e5;
}