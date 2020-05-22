String M1(Set<Book> set) {
  return common(set, Book::getName);
}

String M2(Set<Student> set) {
  return common(set, Student::getName);
}

String M3(Set<Course> set) {
  return common(set, Course::getName);
}