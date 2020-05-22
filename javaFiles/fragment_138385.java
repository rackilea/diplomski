Scanner sc = new Scanner(System.in);
int[] a = acquireArray(sc);
int[] b = acquireArray(sc);
int[] c = merge(a,b);
bubbleSort(c);
arrayPrint(c);