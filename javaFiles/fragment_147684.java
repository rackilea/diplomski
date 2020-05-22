Map<String, Double> products = new TreeMap<String, Double>();
Scanner stock = new Scanner(new File("prices.txt")); 
stock.useDelimiter("\\s+");

while (stock.hasNext()) {
    tempString = stock.nextLine();
    tempdouble = stock.nextDouble();
    products.put(tempString,tempdouble);
}
stock.close();