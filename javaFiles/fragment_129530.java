import java.util.ArrayList; 

public class Student {
    private String name;
    private Integer rollNumber;
    private int m1;
    private int m2;
    private int m3;
    private int totMarks;

    public static boolean larger(Student s1, Student s2){
        if(s1.totMarks < s2.totMarks) return false; 
        else if (s1.totMarks > s2.totMarks) return true;
        // compare names
        else return s1.name.compareTo(s2.name) > 0;
    }

    public static ArrayList<Student> sortSelection(ArrayList<Student> list){
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j< list.size(); j++){
                if(larger(list.get(i), list.get(j))){ // swap
                    Student temp = list.get(i); 
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
    //Getter setter
    public String getName(){
        return name; 
    }

    public void setName(String name){
        this.name = name; 
    }

    public int getTotMarks(){
        return totMarks;
    }

    public void setTotMarks(int totMarks){
        this.totMarks = totMarks; 
    }

    @Override
    public String toString(){
        return String.format("Name: %20s - Total Marks: %3d", name, totMarks);
    }

    public static void main(String[] args){
        Student s1 = new Student(); 
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();

        s1.setName("John Smith");
        s1.setTotMarks(98);
        s2.setName("Jack Smith");
        s2.setTotMarks(98);
        s3.setName("Adam Noob");
        s3.setTotMarks(100);
        s4.setName("Ved Parkash");
        s4.setTotMarks(99);

        ArrayList<Student> list = new ArrayList<>(); 
        list.add(s4);
        list.add(s3);
        list.add(s1);
        list.add(s2);

        System.out.println("Array before sorting:");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).toString());
        }

        Student.sortSelection(list);

        System.out.println("Array after sorting:");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }
}