import java.util.*;
class Main {

    String a, b, c, h, r, s, l;
    String round;
    double aP; double bP; double cP; double hP; double rP; double sP; double lP;

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.parse();
        m.calculate();
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("");
        System.out.print("Input your shape’s “a” value: ");
        a = sc.nextLine();
        System.out.print("Input your shape’s “b” value: ");
        b = sc.nextLine();
        System.out.print("Input your shape’s “c” value: ");
        c = sc.nextLine();
        System.out.print("Input your shape’s “h” value: ");
        h = sc.nextLine();
        System.out.print("Input your shape’s “r” value: ");
        r = sc.nextLine();
        System.out.print("Input your shape’s “s” value: ");
        s = sc.nextLine();
        System.out.print("Input your shape’s “l” value: ");
        l = sc.nextLine();
        System.out.print("Would you like your answer rounded?: ");

        round = sc.nextLine();
        System.out.println("");

        sc.close();
    }

    public void parse() {
        System.out.println(a);
        aP = inputParser(a);
        bP = inputParser(b);
        cP = inputParser(c);
        hP = inputParser(h);
        rP = inputParser(r);
        sP = inputParser(s);
        lP = inputParser(l);
    }

    public void calculate() {
        if(hP != -1 && rP != -1) {
            System.out.println("Cylinder");
            System.out.println(this.rounding(this.surfaceArea(hP, rP)));
            System.out.println(this.rounding(this.volume(hP, rP)));
        }
        if (rP != -1){
            System.out.println("Sphere");
            System.out.println(this.surfaceArea(rP));
            System.out.println(this.volume(rP));
        }
        if (hP != -1 && rP != -1 && sP != -1){
            System.out.println("Cone");
            System.out.println(this.surfaceArea(hP, rP, sP));
            System.out.println(this.volume(hP, rP, sP));
        }
        if (aP != -1 &&  bP != -1 &&  cP != -1 &&  lP != -1 &&  hP != -1){
            System.out.println("Triangular prism");
            System.out.println(this.surfaceArea(aP, bP, cP, lP, hP));
            System.out.println(this.volume(aP, bP, cP, lP, hP));
        }
    }
    public double rounding(double value) {
        if ("yes".equalsIgnoreCase(round)) {
            return Math.round(value);
        }
        return value;
    }
    public double inputParser(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    //surface area for cylinder
    public double surfaceArea(double hP, double rP){
        return (2.0 * Math.PI * Math.pow(rP, 2.0)) + (2.0 * Math.PI * rP * hP);

    }//end surfaceArea

    //surface area for sphere
    public double surfaceArea(double rP){
        return (4.0 * Math.PI * Math.pow(rP, 2.0));

    }//end surfaceArea

    //surface area for cone
    public double surfaceArea(double hP, double rP, double sP){
        return (Math.PI * Math.pow(rP, 2.0)) + (Math.PI * rP * sP);

    }//end surfaceArea

    //surface area for traingular prism
    public double surfaceArea(double aP, double bP, double cP, double lP, double hp){
        return (bP * lP) + (aP * hP) + (bP * hP) + (cP* hP);

    }//end surfaceArea


    //volume for cylinder
    public double volume(double hP, double rP){
        return (Math.PI * Math.pow(rP, 2.0) * hP);

    }//end volume
    //volume for sphere
    public double volume(double rP){
        return ( 4.0 / 3.0 ) * Math.PI * Math.pow(rP, 3.0);

    }//end volume

    //volume for cone
    public double volume(double hP, double rP, double sP){
        return (1.0 / 3.0 ) * Math.PI * Math.pow(rP, 2.0) * hP;

    }//end volume

    //volume for traingular prism
    public double volume(double aP, double bP, double cP, double lP, double hp){
        return (1.0 / 2.0 ) * bP * lP * hP;

    }//end volume

}//end Main