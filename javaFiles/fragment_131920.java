public void addRollNumber() {

  Iterator itr = students.iterator();

  Map<String, String> IdRollNumberPairs = new HashMap<>();
  while(itr.hasNext()) {
    Student std = (Student) itr.next();

    // Look for an other student with the same idNumber in the list
    String rollNumber = IdRollNumberPairs.get(std.getIdNumber());

    // if there is one, copy his rollNumber
    if(rollNumber != null) {
      std.setRollNumber(rollNumber);

    // if not then pick a new roll number
    } else {
      std.setRollNumber(String.valueOf(nextRollNumber));
      IdRollNumberPairs.put(std.getIdNumber(), std.getRollNumber());
      nextRollNumber++;
    }

    // Add student to the list
    newList.add(std);
  }
}