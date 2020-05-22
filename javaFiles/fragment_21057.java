public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Fila dimension? ");
        int n = teclado.nextInt();

        int [] a = new int [n];
        System.out.println("Dimension of Fila: "+a.length);
        System.out.println("Place that you want to add? ");
        int l = teclado.nextInt();

        for (int i = l-1; i <= l-1; i++) {
            System.out.println("Number? ");
            a [i] = teclado.nextInt();
        }
        System.out.println(Arrays.toString(a));

        Fila fila = new Fila(a);
        // Do something else with fila here...
    }
}