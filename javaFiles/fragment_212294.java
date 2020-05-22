@Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "HEYYY", Toast.LENGTH_LONG).show();

        Intent displayLectureIntent = new Intent(getBaseContext(), LectureActivity.class);
        displayLectureIntent.putExtra("lectureExtra", 
                lectureManager.returnLecture(adapterView.getItemAtPosition(position).toString()));
      **if(position !=0){
        startActivity(displayLectureIntent);
  } 
   else{
    Toast.makeText(getApplicationContext(), " select the lecture.", Toast.LENGTH_LONG).show();**
    }
    }