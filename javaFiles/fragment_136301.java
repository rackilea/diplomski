LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View row = inflater.inflate(R.layout.list_item, g, false);

    row.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // Toast.makeText(context,"i'm Clicked",Toast.LENGTH_LONG).show();

            RelativeLayout sub_list=(RelativeLayout)row.findViewById(R.id.sub_layout);
            sub_list.setVisibility(View.VISIBLE);
        }
    });