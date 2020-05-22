// Your code (unchanged, but reformatted a bit)
int[][] tab1 = { {1,2,3}, {1,2,3} };
int[][] tab2 = { {1,2}, {1,2} };
int[][] tab = new int[tab1.length + tab2.length][];
System.arraycopy(tab1, 0, tab, 0, tab1.length);
System.arraycopy(tab2, 0, tab, tab1.length, tab2.length);

// Extend short rows
int rowLen = 0;
for (int[] row : tab)
    if (row.length > rowLen)
        rowLen = row.length;
for (int i = 0; i < tab.length; i++)
    if (tab[i].length < rowLen)
        tab[i] = Arrays.copyOf(tab[i], rowLen);

// Print result
System.out.println(Arrays.deepToString(tab));