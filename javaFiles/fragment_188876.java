static void test1() {
    int i;
    for (i = 0; i < 10; i++)
        ;
    for (i = 0; i < 10; i++)
        ;
}
static void test2() {
    for (int i = 0; i < 10; i++)
        ;
    for (int i = 0; i < 10; i++)
        ;
}