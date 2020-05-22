public static void main(String[] args) {

    String str = "This is an example text like Australia India England";

    Matcher m = Pattern.compile("Australia|India|England").matcher(str);
    while (m.find())        
        System.out.println("Matches: " + m.group());
}