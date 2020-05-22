@Override
protected void onActivityResult(int requestCode,int resultCode,Intent data){
    super.onActivityResult(requestCode,resultCode,data);

    if(requestCode==PLACE_PICKER_REQUEST){

        if(resultCode== RESULT_FIRST_USER){
            Place place = PlacePicker.getPlace(data, MainActivity.this);
            String name = String.format("Place: %s",place.getName());
            location.setText(name);

        }

    }
}