String quitString = "quit";
List<String> userInputList = new ArrayList<>();

try(Scanner scanner = new Scanner(System.in)){ // This is called a "try with resources"
    System.out.println("Start the sequence by inputting a string DIFFERENT than 'quit'. When you DO want to end it, input \"" + quitString + "\"." + System.lineSeparator());

    String encore = scanner.nextLine();

    while(!encore.equalsIgnoreCase(quitString)){
        encore = encore.replaceAll("\\s+", ""); // this way, the length of the strings is only defined by the characters in the string, and not characters + whitespaces.
        System.out.println("Enter the string you want to put in your sequence of strings");

        encore = scanner.nextLine();
        if(encore != null && !encore.isEmpty() && !encore.equalsIgnoreCase(quitString)) {
            userInputList.add(encore);
        }
    }
}
catch(Exception e)
{
    e.printStackTrace();
}

List<String> ascending =
        userInputList.stream()
                .sorted((strA, strB) -> strA.length() - strB.length())
                .collect(Collectors.toList());

List<String> descending =
        userInputList.stream()
                .sorted((strA, strB) -> strB.length() - strA.length())
                .collect(Collectors.toList());

StringBuilder sbAscending = new StringBuilder();
sbAscending.append("Here are your strings in ascending order: ");
ascending.forEach(userInput -> {
    sbAscending.append(System.lineSeparator() + userInput);
});

System.out.println(sbAscending.toString());

StringBuilder sbDescending = new StringBuilder();
sbDescending.append("Here are your strings in descending order: ");
descending.forEach(userInput -> {
    sbDescending.append(System.lineSeparator() + userInput);
});

System.out.println(sbDescending.toString());