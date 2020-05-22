public class SampleClass {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id(){
        return id;
    }

    public SampleClass id(int id){
        this.id=id;
        return this;
    }
}