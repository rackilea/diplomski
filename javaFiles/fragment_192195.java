public Set<Student> getTutees(){
   Set<Student> students = new HashSet<>();
   for (Student student : tutees){
      Student copy = new Student(student.getName(), 
                                    student.getCourse());
      students.add(copy);
   }     
   return Collections.unmodifiableSet(students);
}