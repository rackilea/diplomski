String[] AA = {"DDDD", "HHHH", "ZZZZ"};
    String[] BB = {"DDDD", "HHHH", "ZZZZ"};
    String[] CC = {"DDDD", "HHHH", "ZZZZ"};
    String[] DD = {"DDDD", "HHHH", "ZZZZ"};


    String[][] result = new String[4][AA.length * BB.length * CC.length * DD.length];

    int row = 0;
    for (int i = 0; i < AA.length; i++) {

        for (int j = 0; j < BB.length; j++) {

            for (int k = 0; k < CC.length; k++) {

                for (int L = 0; L < DD.length; L++) {

                    result[3][row] = DD[L];
                    result[2][row] = CC[k];
                    result[1][row] = BB[j];
                    result[0][row] = AA[i];
                    System.out.println(result[0][row] + " " +result[1][row] + " " +result[2][row] + " " +result[3][row]);
                    row++;
                }
            }
        }
    }