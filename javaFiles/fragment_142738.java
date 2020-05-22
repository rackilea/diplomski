Scanner keyboard = new Scanner(System.in);
ArrayList<Double> numbers = new ArrayList( );
String input = keyboard.nextLine();
for(String item : input.split(" ")){
    numbers.add(Double.parseDouble(item));
}