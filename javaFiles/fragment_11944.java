public class ArrayClass {

    private ArrayList<String> array;

    public ArrayClass() {
        array = new ArrayList<>();
    }

    public void add_val(String s){
        array.add(s);
    }

    public int get_size(){
        return array.size();
    }

    public String get_val(int i){
        return array.get(i);
    }
}