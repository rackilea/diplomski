public class FOR
        {
        public static void main (String [] args)
                {
                int number, sum;
                sum=0;

                for (int i=1; i<=4; i++)
                        {
                        number=ConsoleInput.readInt("enter");
                        sum += number;
                        }

                System.out.println("total is" + sum);
                System.exit(0);
                }
        }