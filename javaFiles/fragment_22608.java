boolean found = false;
for(int i = 0; i < students.size() && !found; i++){
    if(students.get(i).askName().equals(readContent[0])){
        //something i do when Student exists
        found = true;
    }
}
if(!found){
    Student student = new Student(readContent[0],adress.toString());
    for(int i = 1; i < readContent.length; i++){
        student.addGrade(readContent[i]);
    }
    students.add(student);  
}