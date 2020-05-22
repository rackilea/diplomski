int ListaLength = 100001;
int [] array = new int[ListaLength];
for (int i = 0; i < ListaLength; i++) {
array[i] = (int)(Math.random() * ((ListaLength - 1) + 1));
 //there is supposed to be a closing bracket here.
Arrays.sort(array);
System.out.println("Skriv in numret du letar efter.");
int element = new Scanner(System.in).nextInt();