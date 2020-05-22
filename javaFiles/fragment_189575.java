Scanner reader = new Scanner(System.in);
outer: while (true) {
    System.out.println("Enter the name or symbol of an element in the periodic table. ");
    String input = reader.nextLine().trim();
    for (Element sy : Element.values()) {
        if (sy.symbol.equalsIgnoreCase(input) || sy.name().equalsIgnoreCase(input)) {
            System.out.println("Element: " + sy + " (" + sy.symbol + ")" + "\nGroup: " + sy.group + "\nAtomic Mass: " + sy.weight);
            break outer;
        }
    }
    System.out.println("No such element found. ");
}
reader.close(); // this might be a bad idea