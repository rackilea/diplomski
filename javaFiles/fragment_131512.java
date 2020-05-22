List<Teacher> teachers = new ArrayList<Teacher>();

BufferedReader inFile = new BufferedReader (new FileReader 
           ("pathtofile/teachers.txt"));

String inputLine;
while ( (inputLine = inFile.readLine() ) != null) { // read one line at a time

    String[] teacherVars = inputLine.split(":"); // split into a string array.
    teachers.add(new Teacher(teacherVars[0], teacherVars[1], teacherVars[2], teacherVars[3]);
}