static int x = method("x");

static {
    System.out.println("init 1");
}

static int y = method("y");

static {
    System.out.println("init 2");
}

static int method(String name) {
    System.out.println(name);
    return 0;
}