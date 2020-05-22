interface PersonQueryBuilder<T extends Person, U extends PersonQueryBuilder<T,U>> {
    U withName(String name);

    U withAgeBetween(int from, int to);
}

interface StudentRepository extends PersonQueryBuilder<Student, StudentRepository> {
    StudentRepository studying(Course course);
}