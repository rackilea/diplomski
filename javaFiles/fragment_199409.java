public class Subject
{   
    private String subjectcode;
    private final List<Employee> employees = new ArrayList<Employee>();

    public Subject(String subjectcode){
        this.subjectcode = subjectcode;
}

public boolean addStaff(Employe employe){
        return this.employees.add(employe);
 }