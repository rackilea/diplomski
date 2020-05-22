for (Student student : rows) {
    String studentname = student.getName(); 
    if (!names.add(studentname) {
        dups.add(studentname);
    }
}