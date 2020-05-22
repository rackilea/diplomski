@Override
public boolean equals(Object obj) {

    if (this == obj) {
        return true;
    }

    if (!(obj instanceof Employee)) {
        return false;
    }
    Employee other = (Employee) obj;

    return super.equals(other) &&
           Double.compare(this.salary, other.salary) == 0 &&
           this.hireDay.equals(other.hireDay);

}