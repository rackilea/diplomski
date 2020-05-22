enum Example {
    INSTANCE {{
        subversion();
    }};

    static void subversion() {
        System.out.println(INSTANCE);
    }

    public static void main(String[] args) {
        System.out.println(INSTANCE);
    }
}