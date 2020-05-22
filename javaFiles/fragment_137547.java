public Student getMostImprovedStudent()
{
    return Arrays.stream(students)
                 .max(Comparator.comparing(Student::getExamRange))
                 .get();                     
}