ArrayList<HolderAnswer> listAnswers = getAnswers();
ArrayList<ArrayList<HolderAnswer>> listAnswersSorted =
new ArrayList<ArrayList<HolderAnswer>>();

// initialize the ArrayLists in listAnswersSorted
int numRows = listAnswers.size() / numColumns + 1;
for (int i = 0; i < numRows; i += 1) {
  listAnswersSorted.add(new ArrayList<HolderAnswer>());
}

// calculate column index where the "step" happens
int step = listAnswers.size() % numColumns;

// loop through and add elements to listAnswersSorted
int index = 0;
int row = 0;
int col = 0;
while (index < listAnswers.size()) {
  listAnswersSorted.get(row).add(listAnswers.get(index));

  int rows = col < step ? numRows : numRows - 1;
  row += 1;
  if (row == rows) {
    row = 0;
    col += 1;
  }
  index += 1;
}

// flatten the ArrayList<ArrayList> into a single ArrayList
ArrayList<HolderAnswer> newList = new ArrayList<HolderAnswer>();
for (ArrayList<HolderAnswer> list : listAnswersSorted) {
   newList.addAll(list);
 }