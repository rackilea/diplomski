public static final String CSV_SEPARATOR  = ",";
  ...
  Map.Entry<Integer, Student> studentEntry = iterator.next();
  int key = studentEntry.getKey();
  Student student = studentEntry.getValue();
  String line = "Student ID: " + key + CSV_SEPARATOR + student.getName() 
  +  CSV_SEPARATOR  + student.getMajor() + System.lineSeparator();
  bW.write(line);