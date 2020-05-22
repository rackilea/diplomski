public Offer(Parcel in) {
    this.id  = in.readInt();
    this.title = in.readString();
    this.myShop = in.readParcelable(Shop.class.getClassLoader());
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.title);
    dest.writeParcelable(this.myShop, flags);
}