public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(type);
    dest.writeString(numberPlate);
    dest.writeString(brand);
    dest.writeDouble(pricePerHour);
    dest.writeDouble(pricePerKm);
    dest.writeString(objectId);
    dest.writeInt(photo.length());
    dest.writeByteArray(photo);
}



public void readFromParcel(Parcel in){
    this.type = in.readString();
    this.numberPlate = in.readString();
    this.brand = in.readString();
    this.pricePerHour = in.readDouble();
    this.pricePerKm = in.readDouble();
    this.objectId = in.readString();
    this.photo = new byte[in.readInt()];
    in.readByteArray(this.photo);
}