public void deleteStudent(int studentID){
  Iterator<Student> iterator=listStudent.iterator();
  while (iter.hasNext()){
    Student ob = iterator.next();
    if (ob.getStudentID() == studentID){
      iterator.remove(student);
      break;
    }
  }
}