public void add() {
    Student student;
    addStudent = (Button) findViewById(R.id.add);
    addStudent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivityForResult(intent,123);
        }
    });
}
}