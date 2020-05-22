import java.util.Scanner;

    class QuadraticEquation {
        private double a;
        private double b;
        private double c;
        public QuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double calculateDiscriminant() {
                return (b*b - 4 * a * c);
        }


    }
    public class Calculation{
        public static void main(String []args) {

            Scanner scan = new Scanner(System.in);
            double a = Dialog.isEnteredValues(scan, "a");
            double b = Dialog.isEnteredValues(scan, "b");
            double c = Dialog.isEnteredValues(scan, "c");

            QuadraticEquation eq = new QuadraticEquation(a, b, c);

            double disc = eq.calculateDiscriminant();
            if(disc < 0) {
                Dialog.isNoSolution();
            }else if(disc > 0) {
                 double x1 = (-b - Math.sqrt(disc)) / 2 * a;
                 double x2 = (-b + Math.sqrt(disc)) / 2 * a;
                 Dialog.isTwoSolution(x1, x2);
            }else {
                  double x0 = -b / (2 * a);
                  Dialog.isOneSolution(x0);
            }

        }
    }
    class Dialog {

    //  public void isEnteringValues()
    //  {
    //      switch (???) {
    //          case a:
    //              System.out.print("Input A: ");
    //          case b:
    //              System.out.print("Input B: ");
    //          case c:
    //              System.out.print("Input C: ");
    //      }
    //  }

      static double isEnteredValues(Scanner scan, String str)
      {
          System.out.println("Enter value " + str);
          return scan.nextDouble();
      }

      static void isNoSolution()
      {
          System.out.println("No solution.");
      }

      static void isOneSolution(double x0)
      {
          System.out.println("x0: " + x0);
      }

      static void isTwoSolution(double x1, double x2)
      {
          System.out.println("x1: " + x1);
          System.out.println("x2: " + x2);
      }
    }