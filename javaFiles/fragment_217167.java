public void writeToParcel(Parcel out, int flags) {
    out.writeString(_mac);
    out.writeString(_pan);
    out.writeInt(_band);
    out.writeSerializable(_lqis);
    out.writeTypedList(_devices);
}

private ZigBeeNetwork(Parcel in) {
    _mac = in.readString();
    _pan = in.readString();
    _band = in.readInt();
    _lqis = (ArrayList<Integer>) in.readSerializable();
    in.readTypedList(_devices, ZigBeeDev.CREATOR);
}