class Student<T> implements Comparable
{
private String studName;
private Integer gradeAverage;

public Student(String nameIn, int gradeIn)
{
    studName = nameIn;
    gradeAverage = gradeIn;
}

public int compareTo(Object obj)
{
    Student s1 = (Student)obj;
    if (this.gradeAverage < s1.gradeAverage){
        return -1;
    }
    if(this.gradeAverage == s1.gradeAverage){
        return 0;
    }

    return 1;
}

@Override
public String toString(){
    return "student name="+studName +" grade average= " + gradeAverage;
}
}