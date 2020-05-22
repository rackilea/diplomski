public static void main(String[] args) {
    Scanner ns = new Scanner(System.in);
    int n = 0;
    int i = 1;
    List<Integer> params = new ArrayList<>();
    while (i <= 5) {
        System.out.println("enter a number");
        n = ns.nextInt();
        params.add(n);
        i++;
    }
    for (Integer param : params) {
        System.out.println(param);
    }
}