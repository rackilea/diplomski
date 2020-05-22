public class Bouns {

    final static int DEPT1_EMP = 250;
    final static int DEPT2_EMP = 500;
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        double[] salary_Dept1 = new double[DEPT1_EMP];
        double[] salary_Dept2 = new double[DEPT2_EMP];
        fillArray(salary_Dept1);
        boolean done = false;
        double d;
        char yORn;
        do {
            fillArray(salary_Dept1);
            System.out.println("Enter department: ");
            int dept = read.nextInt();

            if (dept == 1) {
                getBonus((double) dept);    // should be getBounds
            } else if (dept == 2) {
                getBonus(dept);             // shoul be getBounds
            }
            System.out.println("do you want to continue ? y/n ");
            yORn = read.next.charAt(0);     // should be next()
            if (yORn == 'n') {
                done = true;
            }

        } while (!done);

    }

    public static void fillArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = read.nextDouble();
        }
    }

    public static void fillArray2(double[] b) {
        for (int i = 0; i < a.length; i++) {    // a should be b.length
            b[i] = read.nextDouble();
        }
    }

    public static void getBounds(double x) {
        int num;
        for (int i = 1; i <= DEPT1_EMP; i++) {
            System.out.print("How many years have the employee No. " + k);  // k should be i
            num = read.next();   // should be nextInt()
            if (num > 10) {
                salary_Dept1[k] = salary_Dept1[k] + (20 / 100) * salary_Dept1[k];  // salary_Dept1 is not within scope
            }                                                                      // should be declared at static class member
        }

    }

    public static void getBounds(int x) {
        char fORp;
        for (int i = 1; i <= DEPT2_EMP; i++) {
            System.out.print("the empolyee number " + i + " if s/he works full-time or part=time (F/P)?");
            fORp = read.next.charAt(0);   // should be next()
            if (fOrp == 'F') {   // fOrp should be fORp, look at your declaration
                salary_Dept2[i] = salary_Dept2[i] + 700;
            } else if (fOrp == 'P') {
                salary_Dept2[i] = salary_Dept2[i] + 250;  // salary_Dept2 out of scopr
                                                          // should be declared as static class member
            }

        }
    }
}