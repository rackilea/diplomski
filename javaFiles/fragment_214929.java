public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test =sc.nextInt();
        while(test>0){
            int num = sc.nextInt();
            int n = totalTree(num);
            System.out.println("totalTree"+n);
            test--;
        }
    }

    public static int totalTree(int n) {
        if (n == 1 || n == 0)
            return 1;
        else {
            int left = 0;
            int right = 0;
            int sum = 0;
            for (int k = 1; k <= n; k++) {
                left = totalTree(k - 1);
                right = totalTree(n - k);
                sum = sum + (left * right);
            }
            return sum;
        }
    }