String input = br.readLine();

try {
    Integer.parseInt(input);
    System.out.println("Integer");
} catch(NumberFormatException nfe) { // not an int
    try {
        Float.parseFloat(input);
        System.out.println("Float");
    } catch(NumberFormatException nfe) { // not a float either
        System.out.println("String");
    }
}