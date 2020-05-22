private static final void recurse(int val) {
    System.out.println(val);
    recurse(val + 1);
}
public static void main(String[] args) {
    recurse(1);
}