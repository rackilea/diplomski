File input = new File("Desktop/Lotion.txt");
Scanner scanner;
scanner = new Scanner(input);
while(scanner.hasNext()){
    String readLine = scanner.nextLine();
    String[] strArray = readLine.split(",");
    int indexOfProductNo = Integer.parseInt(strArray[1].trim());
    int indexOfProductRating = Integer.parseInt(strArray[2].trim());
    double indexOfProductDiscount = Double.parseDouble(strArray[3].trim());
    lotion.add(new Lotion(strArray[0],indexOfProductNo,indexOfProductRating,indexOfProductDiscount));
}