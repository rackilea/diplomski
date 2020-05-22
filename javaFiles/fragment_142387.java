public class MultiplicationTable {
public static void main(String[] args) {
    for (String s : getMultiplicationTable(5)) {
        System.out.println(s);
    }

}
public static List<String> getMultiplicationTable(int size) {
    List<String> strings = new ArrayList<>();

    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%4s", ""));
    for (int i = 1; i <= size; i++) {
        sb.append(String.format("%4d", i));
    }
    strings.add(sb.toString());

    for (int i = 1; i <= size; i++) {
        sb = new StringBuilder();
        sb.append(String.format("%4d", i));
        for (int j = 1; j <= size; j++) {
            sb.append(String.format("%4d", i * j));
        }
        strings.add(sb.toString());
    }
    return strings;
}
}