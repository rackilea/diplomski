public class AdapterPeople extends ArrayAdapter<People> {
    private ArrayList<? extends People> arrPeople;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterPeople(@NonNull Context context, int resource, @NonNull ArrayList<? extends People> objects) {
        super(context, resource, objects);
        this.arrPeople = objects;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }