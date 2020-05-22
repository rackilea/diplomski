class LocationInfo {
   private String latitudeInfo;
   private String longitudeInfo;     
   ...
}

class PictureInfo {      
  private String description; //I assume that's what pictureInfo means
  private LocationInfo locInfo;
  ...
}

Map<Marker, PictureInfo> infoMap = ...;