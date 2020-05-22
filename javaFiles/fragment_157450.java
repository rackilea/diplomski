@Keep
public class Location implements Parcelable {

public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Location>() {
    public Location createFromParcel(Parcel in) {
        return new Location(in);
    }

    public Location[] newArray(int size) {
        return new Location[size];
    }
};

private String id;
private String user_id;
private String name;
private String address;
private double latitude, longitude;
private String place_id = "";

private Location(Parcel in) {
    id = in.readString();
    user_id = in.readString();
    name = in.readString();
    address = in.readString();
    latitude = in.readDouble();
    longitude = in.readDouble();
    place_id = in.readString();
}

public Location() {

}

/// used for onCreate for the home location, nothing else
public Location(String name, String address,
                double latitude, double longitude, String placeId) {

    this.name = name;
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
    this.place_id = placeId;

}


public Location(
        String userId,
        String name,
        String address,
        double latitude, double longitude, String placeId) {

    this.user_id = userId;
    this.name = name;
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
    this.place_id = placeId;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getUserId() {
    return user_id;
}

public void setUserId(String userId) {
    this.user_id = userId;
}

public double getLatitude() {
    return latitude;
}

public void setLatitude(double latitude) {
    this.latitude = latitude;
}

public double getLongitude() {
    return longitude;
}

public void setLongitude(double longitude) {
    this.longitude = longitude;
}

public String getPlaceId() {
    return place_id;
}

public void setPlaceId(String placeId) {
    this.place_id = placeId;
}


@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(id);
    parcel.writeString(user_id);
    parcel.writeString(name);
    parcel.writeString(address);
    parcel.writeDouble(latitude);
    parcel.writeDouble(longitude);
    parcel.writeString(place_id);
}

@Override
public String toString() {
    return "Location{" +
            " id='" + id + '\'' +
            ", user_id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", latitude='" + latitude + '\'' +
            ", longitude='" + longitude + '\'' +
            ", place_id='" + place_id + '\'' +
            '}';
}

public android.location.Location getLocation() {
    android.location.Location loc = new android.location.Location("");
    loc.setLatitude(this.getLatitude());
    loc.setLongitude(this.getLongitude());
    return loc;


}