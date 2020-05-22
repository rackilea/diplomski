ArrayList<Integer> numbers = new ArrayList<Integer>();
int numberIn;
Scanner scan = new Scanner(System.in);
System.out.println("Enter numbers!");

String input;
while (!(input = scan.nextLine()).isEmpty()) {
    numberIn = Integer.parseInt(input);
    numbers.add(numberIn);
}

System.out.println("Numbers: " + numbers + ".");