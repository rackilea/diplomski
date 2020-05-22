public string extractStudentID(string input)
 {
      string [] parts = input.substring(1,input.length-1).split(",");

      return parts[1].split("=")[1];
 }