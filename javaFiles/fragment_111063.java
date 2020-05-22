public class MyListDataAdapter extends ArrayAdapter<MyListData> {

    private static final String TAG = "MyListDataAdapter";


    public MyListDataAdapter(Context context, ArrayList<MyListData> data) {
        super(context, 0, data);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        final MyListData data = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.edit_list_item, parent, false);
        }

        // Add a TextView if you need one
        final TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        Button btnEditTicketHolder = (Button) convertView.findViewById(R.id.btnEdit);
        btnEditTicketHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long userId = data.getUserId();
                String fName = data.getFirstName();

                Intent intent = new Intent(getContext(), EditActivity.class);
                intent.putExtra("userId", userId);
                intent.putExtra("fName", fName);
                getContext().startActivity(intent);
            }
        });


        String name = data.getFirstName();
        tvName.setText(name);
        return convertView;
    }

}