String input = "-123.[1]2_3";
input = input.replaceAll("[^0-9.-]+", "");
if (input.matches("-?\\d+(?:\\.\\d+)?")) {
    System.out.println("Found a valid number: " + input);
}
else {
    System.out.println("Input is invalid");
}