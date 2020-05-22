public class Main{
    public static void main(String args[]) throws IOException{
        new Main().go();
    }

    public void go() throws IOException{
        Scanner input = new Scanner(System.in);
        int T;
        T = input.nextInt();
        input.nextLine();
        System.out.println("T is " + T);
        int[] k_holder = new int[T];
        int[] n_holder = new int[T];
        int[][] array  = new int[T][10000];

        for (int i=0; i<T; i++) { // length of array
            n_holder[i] = input.nextInt();
            input.nextLine();
            System.out.println("n_holder[" +i + "] is " + n_holder[i]);

            String tmp[] = input.nextLine().split(" ");
           for(String e : tmp){
                System.out.print(" " + e);
            }

            for (int j=0;j<tmp.length; j++) {
                array[i][j] = Integer.parseInt(tmp[j]);
            }

            int K = input.nextInt(); // difference
            input.nextLine();
            k_holder[i] = K;
        }
        System.out.println("===============");

        for (int i=0; i<T; i++) {
            System.out.println(n_holder[i]);

            for (int j=0; j<n_holder[i]; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n" + k_holder[i]);
        }
    }
}