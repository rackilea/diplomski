public Tutor(String name, Student[] students){
  this.name = name;
  tutees = new HashSet<Student>();
  for (Student student : students){   
      Student copy = new Student(student.getName(), 
                                    student.getCourse());
      tutees.add(copy);
   }     
}