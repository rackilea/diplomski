File file = new File("C:/Users/Josh/Desktop/prog5input.csv");
Scanner sc = new Scanner(file);
while(sc.hasNextLine()){
      String str = sc.nextLine();
      String[] arr = str.split(",");
      int accountType = Integer.valueOf(((String)arr[0]).trim());
      ......
}