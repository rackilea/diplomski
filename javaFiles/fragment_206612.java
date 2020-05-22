public static void main(String[] args) {
    int a = 60;
    int b = 24;

    for(int i = Math.min(a, b); i > 0; i--){
        if(a % i == 0 && b % i == 0){
            System.out.println("GCD: " + i);
            break;
        }
    }
}