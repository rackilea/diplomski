@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View view = convertView;
    ViewHolder holder = null;

    LayoutInflater inflater = (LayoutInflater) context.getSystemService((Activity.LAYOUT_INFLATER_SERVICE));

    if (view == null) {
        view = inflater.inflate(layoutResourceId, parent, false);

        holder = new ViewHolder();
        holder.title = (TextView)view.findViewById(R.id.tv_cardTitle);
        holder.companyname = (TextView)view.findViewById(R.id.tv_companyName);
        holder.description = (TextView)view.findViewById(R.id.tv_cardDesc);

        view.setTag(holder);
    } else {
        holder = (ViewHolder)view.getTag();
    }

    Card j = cards.get(position);

    holder.title.setText(j.getCardTitle());
    holder.companyname.setText(j.getCompanyName());
    holder.description.setText(j.getDescription());

    // JUST DEFINE THE CLICK LISTENER HERE

    holder.description.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //open up a fragment to display the entire carddescription
            //makeToast(getApplicationContext(), "Test description click");
            Toast.makeText(contex, "Test description click :"+position, Toast.LENGTH_SHORT).show();
        }
    });

    return view;
}