final ListAdapter adapter = new SimpleAdapter
            (MainActivity.this, personList, R.layout.list_item,
            new String[]{TAG_ID,TAG_NAME,TAG_ADD},
            new int[]{R.id.id, R.id.name, R.id.address}) {

         public View getView(int position, View convertView, ViewGroup parent) {
             View view = super.getView(position, convertView, parent);

             final TextView quant=(TextView)view.findViewById(R.id.quantity);
             final ImageButton b_plus=(ImageButton)view.findViewById(R.id.ib_plus);
             final ImageButton b_minus=(ImageButton)view.findViewById(R.id.ib_minus);

             b_plus.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     count++;
                     quant.setText(Integer.toString(count));
                 }
             });
             b_minus.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     count--;
                     quant.setText(Integer.toString(count));
                 }
             });

             return view;
         }
     };