List<String> myList = new ArrayList<>();

private void method(int page) {
  try {
    myList.clear();            // Clear the list.
    Scanner temp = new Scanner(fileToPrint);
    for (int i = 0; i < page - 1; i++) {
      skipAPage(temp);
    }
    for (int i = 0; (i < LINES_PER_PAGE) && (temp.hasNext()); i++) {
      myList.add(expandTabs(temp.nextLine()));    // Add the elements to the list.
    }
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  }
}