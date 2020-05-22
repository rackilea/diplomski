@Accessors(fluent = true) // order matters
@Data
class A {
    private int i;
    public static void main(String[] args) {
        new A().i();
    }
}