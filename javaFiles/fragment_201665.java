public static produktas[] surasti(produktas G[], int n) {
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                System.in));
        produktas A[] = new produktas[5];
        for (int j = 0; j < 5; j++) {
            System.out.println("Kokio produkto ieskosime?");
            String found = in.readLine();
            for (int i = 1; i < n; i++) {
                if (found.equals(G[i].gautiPav())) {
                    A[j] = G[i];
                }
            }
        }
        return A;
    } catch (IOException ie) {
        ie.printStackTrace();
        return null; // Expected return from catch block
    }
}