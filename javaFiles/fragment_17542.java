public class AsyncTaskInsideActivity extends AsyncTask<Void, Void, List<List<String>>> {

    private static final String CLASS_TAG = AsyncTaskInsideActivity.class.getSimpleName();

    @Override
    protected List<String> doInBackground(Void... params) {

Log.v(CLASS_TAG, "AsyncTaskInsideActivity started successfully....");

SoCalledDbHelper soCalledDbHelper = new SoCalledDbHelper
        (getBaseContext());

//key-value pairs for inserting data into the table
ContentValues soCalledValues = new ContentValues();
soCalledValues.put(SoCalledContract.LocationTable.COLUMN_CITY_NAME, "Kim Kardishian");
soCalledValues.put(SoCalledContract.LocationTable.COLUMN_STATE, "No Ass Holes");
soCalledValues.put(SoCalledContract.LocationTable.COLUMN_ZIP_CODE, 007);

//insert location data
soCalledDbHelper.addLocationData(soCalledValues);
//For storing the cursor data which will be retrieved by the read query.
Cursor locationDataCursor;

//Query for all the data in the location table
locationDataCursor = soCalledDbHelper.getAllLocationData(null, null, null, null);

List<String> sCLocationId = new ArrayList<String>();
List<String> sCCityName = new ArrayList<String>();
List<String> sCState = new ArrayList<String>();
List<String> sCZipCode = new ArrayList<String>();

if (locationDataCursor.getCount() > 0) {
    //Reset the cursor location
    locationDataCursor.moveToPosition(-1);
    while (locationDataCursor.moveToNext()) {
        //Extracting data from the location cursor
        sCLocationId.add(locationDataCursor.getString
                (locationDataCursor.getColumnIndex("_id")));
        sCCityName.add(locationDataCursor.getString
                (locationDataCursor.getColumnIndex("city_name")));
        sCState.add(locationDataCursor.getString
                (locationDataCursor.getColumnIndex("state")));
        sCZipCode.add(locationDataCursor.getString
                (locationDataCursor.getColumnIndex("zip_code")));
    }
    Log.i(CLASS_TAG, "Success: Cursor has data! #Total Records: " +
            locationDataCursor.getCount());
    for (String locationIds : sCLocationId) {
        Log.i(CLASS_TAG, "Location Id: + " + locationIds);
    }
    for (String cityNamez : sCCityName) {
        Log.i(CLASS_TAG, "City Names: + " + cityNamez);
    }
    for (String statesNames : sCState) {
        Log.i(CLASS_TAG, "State Names: + " + statesNames);
    }
    for (String zipCodes : sCZipCode) {
        Log.i(CLASS_TAG, "Zip Codes: + " + zipCodes);
    }
} else {
    Log.w(CLASS_TAG, "Error: Cursor is empty! #Total Records: " +
            locationDataCursor.getCount());
}
locationDataCursor.close();
soCalledDbHelper.close();

//Creating a List that can store List(s) within it.
//List of Lists String
List<List<String>> arrayOfLists = new ArrayList<List<String>>();

//Adding those Lists that was used to store each column records
arrayOfLists.add(sCLocationId);
arrayOfLists.add(sCCityName);
arrayOfLists.add(sCState);
arrayOfLists.add(sCZipCode);

//Start iterating over the parent arrayOfLists List 
for(int i = 0; i < arrayOfLists.size(); i++) {
    //Print each arrayOfLists data item it contains
    Log.v(CLASS_TAG, "Parent List: " + arrayOfLists.get(i).toString());
    //Start iterating over child of arrayOfLists List
    for(int j = 0; j < arrayOfLists.get(i).size(); j++) {
        //Print each arrayOfLists CHILD data item it contains
        Log.v(CLASS_TAG, "Child List: " + arrayOfLists.get(i).get(j).toString());
    }
}
        //Size of the arrayOfLists  
        Log.v(CLASS_TAG, "Parent List Size: " + Integer.toString(arrayOfLists.size()));
        //Size of the arrayOfLists child container  
        Log.v(CLASS_TAG, "Child List Size: " + Integer.toString(arrayOfLists.get(1).size()));
Log.v(CLASS_TAG, "AsyncTaskDbHelper ended successfully....");
return arrayOfLists;
}