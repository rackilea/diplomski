public class LetterCount {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    List<String> words = new ArrayList<>();
    for (var i = 0; i < 5; i++) {
        System.out.println("Getting word " + (i + 1) + " out of 5");
        words.add(scanner.nextLine());
    }

    long count = words.stream().flatMapToInt(String::chars).count();
    System.out.println("total count is:: " + count);
    }

}