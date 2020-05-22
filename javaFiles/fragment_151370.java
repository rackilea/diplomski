public class empCreate { 
    private Emp emp;

    public empCreate() { 
        emp = new Emp(); 
        emp.setEmpName("abc"); 
    } 

    public Emp getEmp(){
        return emp;
    }
}