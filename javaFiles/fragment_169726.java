public void printName(String name) throws InvalidNameException {
    try {
        String[] nameSplit = name.split(" ");
        String first = nameSplit[0];
        String last = nameSplit[1];

        System.out.println("First name: " + first);
        System.out.println("Last name: " + last);
    } catch (ArrayIndexOutOfBoundsException e) {
        throw new InvalidNameException("Missing space in: " + name);
    }
}