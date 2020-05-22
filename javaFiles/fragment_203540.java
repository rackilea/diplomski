public static String[][] transpose(String[][] m){
    String[][] temp = new String[m[0].length][m.length];
    for (int i = 0; i < m.length; i++)
        for (int j = 0; j < m[0].length; j++)
            temp[j][i] = m[i][j];
    return temp;
}