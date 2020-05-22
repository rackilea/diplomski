public static void main(String[] args) {
    try {
        Scanner in = new Scanner(new File("foo.txt"));
        in.useDelimiter(", ");

        while(in.hasNext()) {
            System.out.println(in.next());
        }
    }
    catch (Exception e) {
    }
}