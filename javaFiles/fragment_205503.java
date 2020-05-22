public class Customlist extends ArrayAdapter<HashMap<String, String>> {
    private Context context;
    private ArrayList<HashMap<String, String> contactlist;

    public Customlist(Context context, ArrayList<HashMap<String, String>> contactlist) {
        super(context, R.layout.model, contactlist);
        this.context = context;
        this.contactlist= contactlist;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.model, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.namelist);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imagelist);


        // Contact
        HashMap<String, String> contact = contactlist.get(position);

        String id = contact.get("id");
        String name = contact.get("name");
        String imageurl = contact.get("imageurl");

        // Do something with value id, name and imageurl

        return rowView;
    }

}