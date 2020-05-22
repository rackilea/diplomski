public static void main(String args[]) {

        for (int i = 2; i <= 50; i++) {
            System.out.print("Factors of " + i + ": ");
            for (int j = 2; j < i; j++) {
                System.out.println(j);
                if ((i % j) == 0) System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}