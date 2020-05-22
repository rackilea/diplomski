double f[] = {14.0,18.7,9,4.1,6.7,6,6.3,8.4,4,2.9};
double T = 10;
int n = 5;

double w = 2 * Math.PI / T;

for (int i = 1; i <= n; i++) {      
    double area = 0;

    System.out.println("n = " + i);

    for (int t = 0; t < f.length; t++) {
        System.out.println("T = " + t + " .......... " + f[t] * Math.cos(i*(w * t)));
        area += f[t] * Math.cos(i*(w * t));
    }

    System.out.printf("\nTotal Area: \t\t%.2f\n", area);
    System.out.printf("Calculated area: \t%.2f\n\n", (2/T)*area);

}