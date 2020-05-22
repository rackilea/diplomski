lv.setOnItemClickListener(new OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> a, View v, int position, long id) 
        {
             // In the following line "v" refers to the View returned by the `getView()` method; meaning the clicked View.
             TextView txtName = (TextView)v.findViewById(R.id.paramlistView1);
             String name = txtName.getText().toString();
             Intent in = new Intent(this, NextActivity.class);
             in.putExtra("name" , name);
             startActivity(in);
             }
        }
    );