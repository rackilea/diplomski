adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);


    addButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String task = display.getText().toString();
            adapter.add(task);
            adapter.notifyDataSetChanged();
            SavePreferences();


            Intent i = new Intent(HomeTeamScored.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    });
}