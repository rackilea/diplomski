public static void main(String[] args) {
    String input = "1,fish,2,fish\n\n\n";
    Scanner sc = new Scanner(input);
    sc.useDelimiter(",");
    System.out.print(sc.nextInt());
    System.out.println(sc.next());
    System.out.print(sc.nextInt());
    System.out.println(sc.next());

    System.out.println("Done");
    sc.close();

  }