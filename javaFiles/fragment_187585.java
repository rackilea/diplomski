class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        for(int i = 0;i<=5;i++){
            int N = scanner.nextInt();
            if(N > max) max = N;
        }
        System.out.println("bbb " + max);
    }
}