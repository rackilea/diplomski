package grade_db;

import bean.Student;
import bean.Type_Name;
import bean.University;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Sam
 */

public class Main {

    static EntityManager em;
    static EntityManagerFactory emf;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db/grades.odb");

        EntityManager em;
        em = emf.createEntityManager();

        createStudent("stu00001", new Date(631152000000)), "m", "WB", new Type_Name("Bob", "", "Smith"));

        em.close();
        emf.close();
    }

    public static Student createStudent(String student_id, Date dob, String gender, String nationality, Type_Name name){
        Student stu = new Student();
        stu.setDob(dob);
        stu.setGender(gender);
        stu.setName(name);
        stu.setNationality(nationality);

        stu.setCampus_id("cam00001");
        stu.setCourse_id(null);
        stu.setStudent_id(student_id);

        em.persist(stu);
        return stu;
    }
}