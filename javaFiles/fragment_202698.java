public class TestAdapter extends BaseAdapter {

    Context context;

    public TestAdapter(Context context)
    {
        this.context=context;
    }

    //count of number of items in listview may be depending on the array ua passing....here i am keeping 5 it may be according to you!
    int count=5;

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);

        TextView ordentitle=(TextView)convertView.findViewById(R.id.orden_title_text);

        TextView textbox1=(TextView)convertView.findViewById(R.id.textbox1);


        ordentitle.setText("Whatever yout text is");

        textbox1.setText("whatever your text is");

        Button editar=(Button)convertView.findViewById(R.id.edit_btn);

        Button cancel=(Button)convertView.findViewById(R.id.cancel_btn);


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //funtionality of edit button
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //functionality of cancel button
            }
        });


        return convertView;
    }
}