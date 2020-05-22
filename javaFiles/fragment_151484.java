class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getenv("PATH"));
        Runtime.getRuntime().exec("tp").waitFor();
    }
}