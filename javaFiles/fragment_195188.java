@PaperParcel // (1)
public final class User implements Parcelable {
    public static final Creator<User> CREATOR = PaperParcelUser.CREATOR; // (2)

    long id; // (3)
    String firstName; // (3)
    String lastName; // (3)

    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        PaperParcelUser.writeToParcel(this, dest, flags); // (4)
    }
}