@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;

    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.list_entry, null);
        holder = new ViewHolder();
        holder.quantity= (EditText) convertView.findViewById(R.id.quantity);
        holder.plus = (Button) convertView.findViewById(R.id.plus);
        holder.minus = (Button) convertView.findViewById(R.id.minus);
        convertView.setTag(holder);
    }
    else {
        holder = (ViewHolder) convertView.getTag();
    }

    Item item = getItem(position);

    holder.quantity.setText(item.getQuantity());

    holder.plus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        Item item = getItem(position); 
        q_ty = Integer.parseInt(item.getQuantity()); 
        q_ty = q_ty + 1; 
        quantity.setText("" +q_ty);
        item.setQuantity(q_ty);
        }
    });



    return convertView;
}