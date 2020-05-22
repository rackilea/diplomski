public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to number lines, enter a number and I'll give you some other numbers in a line...");

        int usernum;
        int i = 1;
        usernum = in.nextInt();

        while(i <= usernum){
            int j = 1;
            while(j<=i){
                System.out.print(usernum-i+1);
                j++;
            }
            System.out.println();
            i++;
        }//while
    }//numberlines