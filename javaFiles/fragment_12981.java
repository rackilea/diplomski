int[] atTemp = new int[arrsize];
int[] btTemp = new int[arrsize];
for (int i = 0; i < arrsize - 1; i++) {
    atTemp[i] = at[i];
    btTemp[i] = bt[i];
}
at = atTemp;
bt = btTemp;