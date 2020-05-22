listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Student Id 
        String studId = labels.get(position);

        Intent passIntent = new Intent(LecturerSearch.this, LecturerResult.class);
        passIntent.putExtra("keyid", studId);
        startActivity(passIntent);
    }
});