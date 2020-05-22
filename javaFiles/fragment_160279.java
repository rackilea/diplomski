public static void main(String[] args) {
     //your example
     String text2 = "VALUES ('1', 'firstname 1', 'lastname 1', 'address 1')";
     //get a text from ( to ) 
     String getMe = text2.substring(text2.indexOf("(")+1 , text2.lastIndexOf(")"));
     //replace all ' with empty space and split it by ,
     String[] listOfString = getMe.replaceAll("'", "").split(",");
     //print it
     System.out.println(Arrays.asList(listOfString));
}