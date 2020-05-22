Scanner input = new Scanner(System.in);
while(true) {
    try {
        auxInt = input.nextLine().trim();
        aux = Integer.parseInt(auxInt);

        if(aux >= min & aux <= max)
            break;

        System.out.println("Enter a " + message + " between " + min + " & " + max);
    } catch (NumberFormatException ex) {
        System.out.println("Enter a " + message + " between " + min + " & " + max);
}