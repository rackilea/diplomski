public class Stops implements Parcelable {

    private String stop_id;
    private String type;
    private String location;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String from;
    private String to;
    private Commodities[] commodities;


   protected Stops(Parcel in) {
    stop_id = in.readString();
    type = in.readString();
    location = in.readString();
    address = in.readString();
    city = in.readString();
    state = in.readString();
    zip = in.readString();
    from = in.readString();
    to = in.readString();
    commodities = in.createTypedArray(Commodities.CREATOR);
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(stop_id);
    dest.writeString(type);
    dest.writeString(location);
    dest.writeString(address);
    dest.writeString(city);
    dest.writeString(state);
    dest.writeString(zip);
    dest.writeString(from);
    dest.writeString(to);
    dest.writeTypedArray(commodities, flags);
}

@Override
public int describeContents() {
    return 0;
}

public static final Creator<Stops> CREATOR = new Creator<Stops>() {
    @Override
    public Stops createFromParcel(Parcel in) {
        return new Stops(in);
    }

    @Override
    public Stops[] newArray(int size) {
        return new Stops[size];
    }
};
}