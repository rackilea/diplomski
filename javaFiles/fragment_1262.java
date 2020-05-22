public static void main (String args[]){
        double[][] g = RandomArray(3);
        printArray(g);
    }

    private static void printArray(double[][] g) {
        System.out.println(Arrays.deepToString(g));
    }

    public static double[][] RandomArray(int n) {

        double[] [] RandomArray = new double[n] [n];
        Random randomNumberCreator = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                RandomArray[i][j] = randomNumberCreator.nextDouble() * 100;
            }
        }
        return RandomArray;
    }