public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        scan.nextLine();
        while (q > 0) 
        {
            String[] s = scan.nextLine().split(" ");
            solveProb(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
            q-- ;
        }     
    }

    public static void solveProb(int a, int d, int n, int x) 
    {
        System.out.println(a+d + n + x);
    }