Scanner s = new Scanner(System.in);

while (true) {
    String question = questionsList.get(r.nextInt(questionsList.size()));
    System.out.println(question);

    String input = s.nextLine();
    // int input = s.nextInt();    if you want integers

    if (input.equals("0"))
        break;

    // if (input == 0) break;      if you want integers
}