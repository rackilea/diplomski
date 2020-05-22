String startLocation = null;
String endLocation = null;
String type = null;

if(cursorJObInfo.moveToFirst()){
    do{
        startLocation = cursorJObInfo.getString(1);
        endLocation = cursorJObInfo.getString(2);
        type = cursorJObInfo.getString(3);
        Log.d("DB value", startLocation +" "+ endLocation +" "+ type);
    }while(cursorJObInfo.moveToNext());
}

// ...
startLocationView.setText(startLocation); // instead of calling getString() on the cursor here
// the same for the other textviews