package pkg;

import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String arg[]){
        Student one=new Student();
        one.setName("firstname");

        AllStudent all=new AllStudent();
        all.add(one);

        // Now changing name of student

        one.setName("secondname");

        // Here I getAll Students

        Collection<Student> cs=all.getAll();

        java.util.Iterator<Student> itr=cs.iterator();

        while(itr.hasNext()){
            Student rgc=itr.next();
            System.out.println(rgc.getName());
        }

    }
    static class Student{
        private String name;
        void setName(String name){
            this.name = name;
        }
        String getName(){
            return name;
        }
    }    
    static class AllStudent{
        Collection<Student> stds = new HashSet<Main.Student>();

        void addAll(Collection<Student> stds){
            this.stds = stds;
        }

        void add(Student std){
            this.stds.add(std);
        }
        public Collection<Student> getAll(){
            return stds;
        }

    }
}