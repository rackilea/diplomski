Map<String, String> firstFile = readFileAndConvert("Files\\deploystudio.csv");
Map<String, String> secondFile = readFileAndConvert("Files\\deploystudio2.csv");
int index = 2;
String[][] finalArray =
    {{"Home", "Dan", "Dog", "4234"}, {"Home", "Bug", "Chicken", "3213"},
        {"Home", " Hds", "Banana", "4324"}, {"Out", " Bgh", "Poodle", "3129"}};
for(String[] row : finalArray) {
  String valueToFind = row[index];
  if(firstFile.containsKey(valueToFind)) {
    row[index] = firstFile.get(valueToFind);
  } else if(secondFile.containsKey(valueToFind)) {
    row[index] = secondFile.get(valueToFind);
  } else {
    System.out.println("Missing " + valueToFind);
  }
}