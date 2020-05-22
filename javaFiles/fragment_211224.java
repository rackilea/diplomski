public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    ArrayList<String> notes = new ArrayList<>();

    int imageCross; //make this a list if you have multiple images and add similar to notes list

    public CustomListAdapter(Activity context, ArrayList<String> notes, int imageCross) {
        super(context, R.layout.item,notes);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.notes = notes;
        this.imageCross = imageCross;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item, null,false);

        TextView ruleNotesSet = rowView.findViewById(R.id.textView1);
        ImageView image = rowView.findViewById(R.id.icon);

        image.setImageResource(imageCross);
        ruleNotesSet.setText(notes.get(position));
        return rowView;
    }

    public void addNote(String data) {
        notes.add(data);
    }
}