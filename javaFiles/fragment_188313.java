double d = (b * b - 4 * a * c);
double re = -b / (2 * a);

if (d >= 0) {  // i.e. "if roots are real"
    System.out.println(Math.sqrt(d) / (2 * a) + re);
    System.out.println(-Math.sqrt(d) / (2 * a) + re);
} else {
    System.out.println(re + " + " + (Math.sqrt(-d) / (2 * a)) + "i");
    System.out.println(re + " - " + (Math.sqrt(-d) / (2 * a)) + "i");
}