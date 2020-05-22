// collect whole line
  name = scanFile.next(); 

  // split by one or more whitespace OR use your delimiter 
  String[] str = name.split("\\s+");

  // gives name
  String actName = str[0];

  // gives gpa, throws NumberFormatException if str[1] is not double value
  double gpa = Double.parseDouble(str[1]);