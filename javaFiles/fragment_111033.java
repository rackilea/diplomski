public class DataLog implements Serializable {
    //internalize this data.
    private ArrayList<String> data;
    private static final long serialVersionUID = 0L;

    //singleton's constructor should be private.
    private DataLog() {}

    private static DataLog _instance;
    public static DataLog getInstance() {
        if(_instance==null){
            _instance = new DataLog();
        }
       return _instance;
    }

    public ArrayList<String> getData(){
        //copy this if you're worried about it being modified.
        //DO NOT pass this reference around. Pass a reference to data log, 
        //reload GUI relying  on this reference as needed.
        return data;
    }

    public void load(){
         data = //reload string array from disk.
    }

    public boolean add(String entry) {
        super.add(entry);
        return true;
    }

    public void add(int index, String entry) {
        if (index > 0)
            data.add(index,entry);
        else
           data.add(entry);
   }

    public void clear() {
       data.clear();
    }
}