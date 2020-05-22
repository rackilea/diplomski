class StudentComparator implements Comparator<Student> {
  @Override
  public int compare(Student student1, Student student2) {
      return student1.getStatus()
               .compareTo(student2.getStatus());
  }
  //Override other methods if need to
}