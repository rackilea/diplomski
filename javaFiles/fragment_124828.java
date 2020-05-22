public class Employee {

private int id;

public Employee(int id){
    this.id = id;
}

public int getId() {
    return id;
}

@Override
public String toString() {
    return "Id : " + this.id;
}

@Override
public boolean equals(Object obj) {
    return (obj instanceof Employee) && this.id == ((Employee)obj).getId();
}