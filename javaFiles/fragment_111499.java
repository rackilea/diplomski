class INTEST {
    public static void main(String...s) {
        String str = "";
         Scanner input=new Scanner(System.in);
        try {
            str = input.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
        String[] ar = str.split(" ");

        int n = Integer.parseInt(ar[0]);
        int k = Integer.parseInt(ar[1]);
        int count = 0;
        if (k <= 10000000) {
            int[] t = new int[n];

            for (int i = 0; i <= n - 1; i++) {
                try {
                    t[i] = Integer.parseInt(input.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (t[i] <= 1000000000) {
                    if (t[i] % k == 0) count++;

                } else break;
            }
        }
        System.out.println(count);

    }
}