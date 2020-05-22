double[][] B = new double[n2][m2];
int k;
int l;
for (k = 0; k < n2; k++) {
    for (l = 0; l < m2; l++) {
        String s1 = JOptionPane.showInputDialog("Enter B" + "[" + (k) + (l) + "]" + " element ");
        //A[k][l] = Integer.parseInt(s1);  //This should be populating B
        B[k][l] = Integer.parseInt(s1);    //Change it to this
    }
}