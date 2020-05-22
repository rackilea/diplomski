public void fill(int[] f) {
    Scanner input=new Scanner(System.in);
    for (int i = 0; i < f.length; i++) {
       f[i] = input.nextInt();
    }
    a = new Welcome(f);
    a.printValues();
}