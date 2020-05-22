//Open the Db when the Activity resumes
@Override
protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
    dbInstance.open();
}

//Closethe it when the Activity pauses
@Override
protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    dbInstance.close(); 
}