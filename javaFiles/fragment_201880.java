class Riwo {
static int i = 10;
static {
    m1();
    System.out.println("block1");
}

public static void main(String... args) {
    m1();
    System.out.println("block main");
}

public static void m1() {
    System.out.println(j);
    System.out.println("block m1");
}

static int j = 20;
static {
    System.out.println("end of code");
}
}