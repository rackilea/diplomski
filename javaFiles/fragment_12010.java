@Entity
public class Professor{
    K id;
    List<Student> students;
}

@Entity
public class Student{
    K profid;
    List<Assignments> assignments;
}

@Entity
public class Assignments{
    K studentid;
}