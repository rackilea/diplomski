public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t;
    while(sc.hasNext()) {
        t = sc.nextInt();
        int x = t % 5 == 0 ? 0 : 1;
        System.out.println(((t/5) + x) * 5);
    }
}