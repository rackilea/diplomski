package algorithms;

import java.util.TreeSet;

class Employee implements Comparable<Employee> {
String Name;
int id;
String CompanyName;
String Address;

public Employee(String Name,int id,String CompanyName,String Address) {
    this.Name = Name;
    this.id = id;
    this.CompanyName = CompanyName;
    this.Address = Address;
}

@Override
public String toString() {
    return "Name : "+this.Name+"\tID : "+this.id+"\tCompanyName : "+this.CompanyName+"\tAddress : "+this.Address;
}

@Override
public int compareTo(Employee obj){
    final int BEFORE = -1;
    final int EQUAL = 0;
    final int AFTER = 1;

    if (this.equals(obj)) return EQUAL;

    int comparison = this.Name.compareTo(obj.Name);
    if (comparison != EQUAL) return comparison;

    comparison = this.Address.compareTo(obj.Address);
    if (comparison != EQUAL) return comparison;

    comparison = this.CompanyName.compareTo(obj.CompanyName);
    if (comparison != EQUAL) return comparison;

    comparison = ((Integer)(this.id)).compareTo(obj.id);
    if (comparison != EQUAL) return comparison;

    return EQUAL;
}

   @Override 
   public boolean equals(Object aThat) {
       if (this == aThat) return true;
       if (!(aThat instanceof Employee)) return false;

       Employee that = (Employee)aThat;
       return
           ( this.Address.equals(that.Address)) &&
           (this.id == that.id) &&
           ( this.Name.equals(that.Name) ) &&
           ( this.CompanyName.equals(that.CompanyName) )
         ;
   }
}


public class DemoTreeSet {

public static void main(String[] args) {
    TreeSet<Employee> ts = new TreeSet<>();
    ts.add(new Employee("Panda", 11, "Google", "California"));
    ts.add(new Employee("Panda", 12, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Google", "California"));
    ts.add(new Employee("Panda", 13, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Infosys", "India"));
    ts.add(new Employee("Panda", 11, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Infosys", "India"));
    ts.add(new Employee("Panda", 12, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Google", "California"));
    ts.add(new Employee("Panda", 13, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Infosys", "India"));
    ts.add(new Employee("Panda", 11, "Google", "California"));
    ts.add(new Employee("Panda", 11, "Infosys", "India"));
    for(Employee  e : ts) {
        System.out.println(e);
    }
}