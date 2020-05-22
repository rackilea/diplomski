Scanner scanner = new Scanner(file);

while (scanner.hasNextLine()) {
  Scanner scanner2 = new Scanner(scanner.nextLine()).useLocale(Locale.FRANCE);
  if (!scanner2.hasNextDouble()){ 
    System.out.println("Do not have a pair");
    continue;
  }
  double d1 = scanner2.nextDouble();
  if (!scanner2.hasNextDouble()){ 
    System.out.println("Do not have a pair");
    continue;
  }
  double d2 = scanner2.nextDouble();
  //do something
}