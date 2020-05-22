class Echo {

  public static void main (String [] args) throws java.io.IOException {

    Scanner sc = new Scanner (System.in);
    System.out.print ("Enter some text: ");
    String input = sc.nextLine();
    System.out.println("Zugriff aufgezeichnet");

    FileWrite fw=new FileWriter(new File("fileName.txt"));
    fw.write(input);
    fw.flush();
    fw.close();
  }
 }