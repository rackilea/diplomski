@SuppressWarnings("unchecked")
public D (Parcel in) {
    list = new ArrayList<IA>();
    (...)    
    //ERROR -> list = (ArrayList<IA>) in.readSerializable 
    list = in.readArrayList(IA.class.getClassLoader());
}

@SuppressWarnings("rawtypes")
public static final Parcelable.Creator CREATOR =
new Parcelable.Creator() {
    public D createFromParcel(Parcel in) {
        return new D(in);
    }

    public D[] newArray(int size) {
        return new D[size];
    }
};

public int describeContents() {
    return 0;
}

public void writeToParcel(Parcel dest, int flags) {
    (...)
    dest.writeList(list);
}