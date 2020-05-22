public static void getNumbers(){
ArrayList<Integer> numbers = IO.fileInput();
System.out.println();
int sz = numbers.size();
for (int i = 0; i < sz; i++){
    System.out.println(numbers.get(i).toString());
}