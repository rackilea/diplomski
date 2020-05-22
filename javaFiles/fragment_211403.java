public class A {

    int i, j;

    public A(int i, int j) {
        this.i = i;
        this.j = j;

    }

    @Override
    public boolean equals(Object obj) {
        // First we check if the object is null
        // Then we check if it's the same class as this one
        if(obj == null || obj.getClass()!= this.getClass()) {
            return false;
        }

        A objectA = (A) obj;

        if(this.i == objectA.i) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() 
    { 

        return this.i; 
    }