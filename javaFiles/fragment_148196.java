public void buttonClick () {
    final SampleObj obj = new SampleObj("test");
    Button enterAnotherButton = (Button) findViewById(R.id.enterAnotherButton);
    enterAnotherButton.setOnClickListener(new View.OnClickListener() {
        int i = 1;
        public void onClick(View view) {
            obj.courseName = "test1";
        }
    });

    Button doneButton = (Button) findViewById(R.id.doneButton);
    doneButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            Log.d(TAG, "Result of obj: " + obj.courseName);
        }
    });
}

class SampleObj {
    String courseName;

    public SampleObj(String courseName) {
        this.courseName = courseName;
    }
}