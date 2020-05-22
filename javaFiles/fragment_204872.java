public static void main(String[] args) 
            {
                //call for input
                System.out.println("Please Enter a 3-digit number..");
                Scanner in = new Scanner(System.in);
                int val = in.nextInt();
                int[] num = new int[3];
                if(val<=99) // is not a 3 digit number
                   return;

                int i =2;
                while (val > 0) {
                   num[i]=(val%10);
                   val = val / 10;
                   i--;
                }
                System.out.println("The Sum of the numbers is " + (num[0] + num[1]+ num[2]));
                System.out.println("The Reverse of the numbers is " + num[2] +""+ num[1]+""+ num[0]);

            }