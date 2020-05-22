public class A {

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1; //any number since in this case all objects of class A are equal to everything
        return hash;
    }

}