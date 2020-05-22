public class Misc_ReturnValue<T> {
    public String message;
    public int total;
    public boolean success;
    public ArrayList<T> results = new ArrayList<T>();

    public Misc_ReturnValue(){
        this.success = false;
        this.total = 0;
    }
}