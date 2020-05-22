String a = "1+5*2-4";
System.out.println(a);
String operator[] = a.split("[0-9]+");
String digits[] = a.split("[+-\\/*]");

final int[] index = {0};
int reduced = Stream.of(digits).mapToInt(Integer::parseInt).reduce(0, (int t, int u) -> {
    int result = process(Integer.parseInt(digits[0]), t, u, operator, index[0]);
    index[0]++;
    return result;
});