public static produktas[] surasti(produktas G[], int n) {
    BufferedReader consoleReader = null;
    produktas produktasFound[] = new produktas[5]; // Initalize array to store the produkt found
    try {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        produktas produktasFound[] = new produktas[5];
        int j = 0;//current produktFound index

        while (!exit) {
            System.out.println("Kokio produkto ieskosime?");
            String produktPav = in.readLine();

            if ("q".equals(produktPav)) {
                exit = true;
            } else {
                for (int i=1; i<n; i++){
                    if (found.equals(G[i].gautiPav())){ 
                        A[j] = G[i];
                        j++; 
                    }
                }
            }

            if(j == 5)
                exit = true;
        }
        return produktasFound; // return all the 5 produktas found
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (consoleReader != null) {
            try {
                consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    return produktasFound; //If no produkt is found from the array returned is blank
}