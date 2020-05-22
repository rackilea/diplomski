// generate a List that contains the numbers 0 to 9
List<Integer> digits = IntStream.range(0,10).boxed().collect(Collectors.toList());
// shuffle the List
Collections.shuffle (digits);
// take the first 4 elements of the List
int numbers[] = new int[4];
for(int i=0;i<4;i++){
    numbers[i] = digits.get(i);
}