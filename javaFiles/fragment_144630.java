public static void remove(String sdId){
    Student stud = null;
    for(Student s : studentList){
        if(s.getStudentId().equals(sdId))
            stud = s;
    }
    if(stud != null)
        studentList.remove(stud);
    else
        System.out.println("ID does not exist."); //optional
}