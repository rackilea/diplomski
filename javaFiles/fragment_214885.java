String[] temp = findOut.clone();

for (int i = 0; i < arrayTwo.length; i++) {
        for (int j = 0; j < arrayTwo[i].length; j++) {
            for (int x = 0; x < temp.length; x++) {
                if (arrayTwo[i][j].equals(temp[x])) {
                    arrayTwo[i][j] = arrayOne[i][j];
                    findOut[x] = arrayTwo[i][j];

                    System.out.println("Match found");
                }
                else {
                System.out.println("Not found");
                }
            }
        }
    }