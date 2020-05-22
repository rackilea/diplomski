int [] x= {8,7,5,6,2,4,3,1};
int len = x.length;

int a[] = Arrays.copyOfRange(mergeSort(x), 0, len/2);
int b[] = Arrays.copyOfRange(mergeSort(x), (len/2), len);

System.out.println("A: " + Arrays.toString(a));
System.out.println("B: " + Arrays.toString(b));