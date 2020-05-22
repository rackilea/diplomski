public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    View vi=convertView;

    if(convertView==null)
        vi = lf.inflate(R.layout.single_list_item, null);

    TextView title = (TextView)vi.findViewById(R.id.drug_title); // title
    TextView description = (TextView)vi.findViewById(R.id.drug_description); // description
    TextView id = (TextView) vi.findViewById(R.id.drug_id); //id
    TextView title_id = (TextView) vi.findViewById(R.id.title_i); //title_id
    View crcl = vi.findViewById(R.id.testo);
    final Drug drug = data.get(position); //this line

    // Setting all values in list view
    title.setText(drug.getName());
    description.setText(drug.get_desc());
    id.setText(""+drug.getID());
    title_id.setText(drug.getName().substring(0, 1));

    Typeface tf = Typeface.createFromAsset(this.activity.getAssets(), "Roboto-Thin.ttf");
    Typeface vf = Typeface.createFromAsset(this.activity.getAssets(), "RobotoCondensed-Regular.ttf");
    title.setTypeface(tf);
    title_id.setTypeface(tf);
    description.setTypeface(vf);

    title_id.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);

            builder.setTitle("Choose a Color");
            builder.setView(lf.inflate(R.layout.color_dialog, null));
            builder.show();
            //Toast.makeText(activity, "test" + drug.getID(), Toast.LENGTH_SHORT).show();
        }
    });

    return vi;
}