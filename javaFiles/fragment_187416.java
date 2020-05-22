class Example {
    public static void main(String[] args) {
        System.out.println(comparator() == comparator());
    }

    static Comparator<String> comparator() {
        return (lhs, rhs) -> lhs.compareTo(rhs);
    }
}