while (true){
    System.out.println("Enter \"game , hours\" or \"Quit\"");
    String line = input.nextLine();
    if (line.equals("Quit")) break;
    allGameData.add(line);
    String[] parsedData = line.split(" , ");
    game.add(parsedData[0]);
    hours.add(Integer.parseInt(parsedData[1]));
}