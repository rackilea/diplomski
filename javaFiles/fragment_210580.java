public class Atribut {
    protected int classid;

    public Atribut() {
        classid = 0;
    }

    @Override
    public String toString() {
        return Integer.toString(classid);
    }    
}

public class Cas extends Atribut{
    public Cas() {
        classid = 2;
    }
}