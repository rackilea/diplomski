public static void main(String[] args) throws IOException {
    File f = new File("src/distance.dat");
    System.out.println(f.getAbsolutePath());  //debug here that it's point to the right file
    Scanner q = new Scanner (f);
    int count = Integer.parseInt(q.nextLine().trim());
    System.out.println(count);
}