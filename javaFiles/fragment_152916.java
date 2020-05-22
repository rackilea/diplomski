protected Place(Parcel in) {
    placeId = in.readString();
    latitude = in.readByte() == 0x00 ? null : in.readDouble();
    longitude = in.readByte() == 0x00 ? null : in.readDouble();
    icon = in.readString();
    name = in.readString();
    priceLevel = in.readByte() == 0x00 ? null : in.readInt();
    rating = in.readByte() == 0x00 ? null : in.readDouble();
    vicinity = in.readString();
    capacity = in.readByte() == 0x00 ? null : in.readInt();
}

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(placeId);
    if (latitude == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeDouble(latitude);
    }
    if (longitude == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeDouble(longitude);
    }
    dest.writeString(icon);
    dest.writeString(name);
    if (priceLevel == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeInt(priceLevel);
    }
    if (rating == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeDouble(rating);
    }
    dest.writeString(vicinity);
    if (capacity == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeInt(capacity);
    }
}