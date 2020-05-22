public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    System.out.println("Dame el numero hasta el cual sacare primos");
    int hasta = entrada.nextInt();

    boolean primo = true;
    for(int factor = 2 ; primo && factor < hasta/2 ; factor++){
      primo = hasta % factor != 0;
    }
    if(primo)
      System.out.println("El numero " + actual + " es primo");
    }
}