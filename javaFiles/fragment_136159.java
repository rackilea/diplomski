while(true) {
    System.out.println("Enter a number "+(i+1));
    String input = sc.next();
    int inputValue = 0;
    try {
        inputValue = Integer.parseInt(input);
        arr[i] = inputValue;
        break; // <-- here
    } catch (NumberFormatException e) {
        System.out.println("Invalid number");
    }
}