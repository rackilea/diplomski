enum my_enum { APPLE, BANANA, ORANGE };
int[] foo = {0,2,2,1};
public void test(String[] args) {
    my_enum[] bar = new my_enum[foo.length];
    for (int i = 0; i < foo.length; i++) {
        bar[i] = my_enum.values()[foo[i]];
    }
    System.out.println(Arrays.toString(bar));
}