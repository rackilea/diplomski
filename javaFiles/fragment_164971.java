public class DeviceObject {
   private String objectID, deviceName, status;
   private ParseGeoPoint location;
   int batLevel;

   public DeviceObject(){
      objectID = null;
      deviceName = null;
      location = null;
      batLevel = 0;
      status = null;
   }    
   public void getDeviceLatestData() {
    if (objectID != null) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("DeviceData");
        query.whereEqualTo("DeviceObjectID", objectID);
        query.orderByDescending("createdAt");
        query.setLimit(1);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> ParseDeviceList, ParseException e) {
                if (e == null) {
                    if (ParseDeviceList.size() == 0) {
                        Log.d("debg", "Device not found");
                    } else {
                        for (ParseObject ParseDevice : ParseDeviceList) {
                            status = ParseDevice.getString("Status");
                            batLevel = ParseDevice.getInt("BatteryLevel");
                            location = ParseDevice.getParseGeoPoint("Location");
                            Log.d("debg", "Retrieving: " + deviceName);
                            Log.d("debg", "Status: " + status + " Battery: " + Integer.toString(batLevel));
                        }

                        //callback listener to add marker to map
                        EventBus.getDefault().post(new DataReadyEvent());

                    }
                } else {
                    Log.d("debg", "Error: " + e.getMessage());
                }
            }
        });
    }
}