private void startTraining() {

// parse date & time from database
String trainingStartDate = SharedMemory.getInstance()
    .getCurrentTraining().getDate();

String trainingStartTime = SharedMemory.getInstance()
        .getCurrentTraining().getStartTime();

if ((currentTraining).isLocked()){
    Toast.makeText(
            getApplicationContext(),
            "The training starts on" + " " + trainingStartDate
                    + " at " + trainingStartTime,
            Toast.LENGTH_SHORT).show();
}else{
    Intent intent = new Intent(getApplicationContext(),
            TraineeListActivity.class);
    MainActivity.this.startActivity(intent);

    finish();

} }