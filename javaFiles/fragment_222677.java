static Random rand = new Random();

public void llenarLista() {
    for (int i = 0; i < 20; i++) {
        lista.add(rand.nextInt(10));
    }
    // Collections.shuffle(lista);
    System.out.println(lista);
}