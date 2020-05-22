ArrayList<Integer> coinTypes = new ArrayList<Integer>();
Integer i;
File f = new File(args[0]);
Scanner input = new Scanner(f);

input.nextLine();
int change;
String[] coinsline = input.nextLine().split("\\s");
for(String coin: coinsline) {
    coinTypes.add(Integer.parseInt(coin));
}
change = Integer.parseInt(input.nextLine());
System.out.println("change: " + change);
System.out.println(coinTypes);