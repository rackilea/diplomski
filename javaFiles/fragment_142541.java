Map<String, String> stuMax = 
    studentList.stream()
               .collect(groupingBy(
                    Student::getType, 
                    collectingAndThen(maxBy(comparing(Student::getAge)), v -> v.get().getName()) 
               ));