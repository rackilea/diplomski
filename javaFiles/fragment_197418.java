public static void main(String[] args) {
    System.out.println(valString() + (val1() + val2()));
}

static int val1() {
    System.out.println("val 1");
    return 5;
}

static int val2() {
    System.out.println("val 2");
    return 10;
}

static String valString() {
    System.out.println("val string");
    return "result ";
}