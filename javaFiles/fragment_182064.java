File fileName = new File(System.getProperty("user.home"), "maze.txt");
try (Scanner file = new Scanner(fileName)) {
  while (file.hasNextLine()) {
    String line = file.nextLine();
    if (line.isEmpty()) {
      continue;
    }
    Scanner scanner = new Scanner(line);
    // error starts from here
    String room = scanner.hasNext() ? scanner.next() : "";
    String roomName = scanner.hasNext() ? scanner.next() : "";
    String wall1 = scanner.hasNext() ? scanner.next() : "";
    String wall2 = scanner.hasNext() ? scanner.next() : "";
    String wall3 = scanner.hasNext() ? scanner.next() : "";
    String wall4 = scanner.hasNext() ? scanner.next() : "";
  }
} catch (Exception e) {
  e.printStackTrace();
}