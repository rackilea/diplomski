Scanner sc = new Scanner(System.in);
System.out.println("Masukkan data : ");
while (sc.hasNext()) {
      String x = sc.nextLine().trim();
      x = x.replaceAll("\\s+", "\t");
      System.out.println(x);
}