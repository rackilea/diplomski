public class MyParcelable implements Parcelable {

public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
    @Override
    public MyParcelable createFromParcel(Parcel in) {
        return new MyParcelable(in);
    }

    @Override
    public MyParcelable[] newArray(int size) {
        return new MyParcelable[size];
    }
};

private BigInteger mData;

protected MyParcelable(Parcel in) {
    mData = new BigInteger(in.readString());
}

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(mData.toString());
}
}