input.nextLine();
while (input.hasNextInt()) {
    i = input.nextInt();
    coinTypes.add(i);
}
int change = coinTypes.get(coinTypes.size()-1);
coinTypes.remove(coinTypes.size() - 1);
System.out.println("Change: " + change);
System.out.println(coinTypes);