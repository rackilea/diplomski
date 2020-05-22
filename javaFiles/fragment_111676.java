int[][] a={{3 ,1},{0,2}};
int count = a[0].length;

//Sort the elements
List<Integer> sortedElements = Arrays.stream(a)
    .flatMapToInt(e -> Arrays.stream(e))
    .boxed()
    .sorted()
    .collect(Collectors.toList());

//Now, generate 2D arrays
int[][] arrays = new int[a.length][];
int[] temp = new int[count];
int index = 0;
for(int i = 0; i < sortedElements.size() ; i++){
    if(i % count == 0 && i != 0){
        arrays[index++] = temp;
        temp = new int[count];
    }
    temp[i % count] = sortedElements.get(i);
}
arrays[index++] = temp;

for(int[] e : arrays){
    System.out.println(Arrays.toString(e));
}