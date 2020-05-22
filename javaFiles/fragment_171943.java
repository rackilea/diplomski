public static void selectionsort(int[] userID, double[] donation, PrintWriter output) {
    int min, swap;
    for (int i = 0; i < userID.length - 1; i++) {
        min = i;
        for (int m = i + 1; m < userID.length; m++) {
            if (userID[m] < userID[i]) {
                min = m;
                swap = userID[min];
                userID[min] = userID[i];
                userID[i] = swap;

                swap=donation[min];
                donation[min]=donation[i];
                donation[i]=swap;
            }
        }
        output.println(userID[i] + "   " + donation[i]);
    }
}