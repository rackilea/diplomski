public class Customer {
    private String name;
    private boolean child, student;

    public Customer(String nameIn, int age, boolean studentIn) {

        this.name = nameIn;
        this.student = studentIn;
        this.child = isChild(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isChild(int age) {
        return (age >= 5 && age <= 16);
    }

    public boolean isStudent() {
        return student;
    }

    public boolean isChild() {
        return child;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", child=" + child + ", student=" + student + "]";
    }

}