int i = 3;
int j = 4;
JPanel[][] panelHolder = new JPanel[i][j];    
setLayout(new GridLayout(i,j));

for(int m = 0; m < i; m++) {
   for(int n = 0; n < j; n++) {
      panelHolder[m][n] = new JPanel();
      add(panelHolder[m][n]);
   }
}