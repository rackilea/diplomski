listView.setAdapter(adapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Word word = workouts.get(position);
        Intent in = new Intent(Workout.this, NextActivity.class);
        in.putExtra("Word", wokouts.get(position).yourMethod());
        startActivity(in);

     }
});