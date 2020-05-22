String field = "A";
void foo() {
    String local = "A";
    Runnable r = () -> System.out.println(field + local);
    field = "B";
    local = "B";
    r.run(); // output: "BA"
}