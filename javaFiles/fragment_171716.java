public class YourAdapter extends ArrayAdapter<YourPojo> {

    public static List<YourPojo> listYourPojo = new ArrayList<>();
    Context context;

    public YourAdapter(Context context, List<YourPojo> listYourPojo) {
        super(context, 0, listYourPojo);
        this.context = context;
        this.listYourPojo  = listYourPojo;
    }
}