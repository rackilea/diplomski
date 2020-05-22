ArrayList<String> countrys = new ArrayList<String>();
countrys.add("China 12351235123");
countrys.add("Korea 123532523");
countrys.add("USA 12341235123");

for(String c:countrys){
    String number = c.replaceAll("[^0-9]", "");
    System.out.println(number);
}