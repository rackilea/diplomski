public static void main(String[] args){
    String str = "9933444";
    List<String> lst = Arrays.asList(str.split(""));
    String res = lst.stream().reduce((a,b) -> {
        if (isOdd(a) && isOdd(b)) {
            return a + "-" + b;
        }
        else {
            return a + b;
        }
    }).get();
    System.out.println(res);
}

// grep the last digit from the string and check if it's odd/even
public static boolean isOdd(String x) {
    if (x.length() > 1) {
        if (x.substring(x.length()-1).equals("-")) {
            x = x.substring(x.length()-3, x.length()-2);
        }
        else {
            x = x.substring(x.length() - 1);
        }
    }
    return Integer.parseInt(x) % 2 == 1;
}