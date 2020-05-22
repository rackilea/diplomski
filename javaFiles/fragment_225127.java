String input = scnr.nextLine();
String [] names = input.split (",");
while (names.length != 2) {
    System.out.println ("Enter with one comma");
    input = scnr.nextLine();
    names = input.split (",");
}

// now you can use names[0] and names[1]