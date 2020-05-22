lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
        // argument position gives the index of item which is clicked
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            String selectedclass = data[position];
            Toast.makeText(getApplicationContext(), selectedclass+" selected",   Toast.LENGTH_LONG).show();

            Intent intent = new Intent (timetable.this, SecondActivity.class);
            intent.putExtra("SELECTED_CLASS", selectedclass);
            startActivity(intent);
        }
    });