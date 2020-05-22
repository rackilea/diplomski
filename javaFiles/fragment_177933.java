int classCount = schoolDistrict.stream()
  .map(School::getStudents)
  .flatMap(Collection::stream)
  .map(Student::getClasses)
  .mapToInt(Collection::size)
  .sum();