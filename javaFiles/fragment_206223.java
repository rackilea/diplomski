@Override
    public View getView(final int position, View convertView, ViewGroup parent) { 

        Button btn = (Button)view.findViewById(R.id.cellbtn);
        btn.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
                Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show();
          }
        });
    }