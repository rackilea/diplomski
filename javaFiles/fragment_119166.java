// Check if metadata contains the specific Directory
if (metadata.containsDirectoryOfType(GpsDirectory.class)) {

      GpsDirectory gpsDirectory = metadata.getFirstDirectoryOfType(GpsDirectory.class);

      //Check if Directory contains the specific Tag
      if(gpsDirectory.containsTag(GpsDirectory.TAG_LATITUDE)&& gpsDirectory.containsTag(GpsDirectory.TAG_LONGITUDE)) {

          metaDataString = "[Longtitude]: " + String.valueOf(gpsDirectory.getGeoLocation().getLongitude()) + ", " +
                                    "[Latitude]: " + String.valueOf(gpsDirectory.getGeoLocation().getLatitude()) + ", ";
      }
      else {
        //Show error or notification
      }
}