class TryVariableArgumentList {
    public static void main(String[] args) {
        x("first","second");
    }

    public static void x(String... list) {
        for(String y : list)
            System.out.println(y);
    }
}