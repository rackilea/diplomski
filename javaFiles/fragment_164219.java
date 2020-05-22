listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id)
            {
                Intent intent = new Intent(getApplicationContext(), SingleUser.class);
                intent.putExtra("username", YourModels.get(position).getUsername());//here first get position and than pass data you want to pass
                intent.putExtra("fk_Code", "" + YourModels.get(position).getFk_Code());//take data from your model
                startActivity(intent);
            }
        });