public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int inputCount = sc.nextInt();
    List<Long> inputArr = new ArrayList<>();
    for (int i = 0; i < inputCount; i++){
        inputArr.add(sc.nextLong());
    }
    System.out.println("==================");
    Set<Long> distinctArr = new LinkedHashSet<>(inputArr);
    for (Long input : distinctArr) {
        if(Collections.frequency(inputArr, input) > 1){
            System.out.println(input);
        }
    }
}