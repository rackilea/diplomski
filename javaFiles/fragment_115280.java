public class LB_Adapter extends ArrayAdapter<LB> {
    // Here --------------------------------^

    // And here:
    List<LB> list = new ArrayList<>();

    public LB_Adapter(Context context, int resource){
        super(context, resource);
    }

    public void add(LB object){
        list.add(object);
        super.add(object);
    }
}