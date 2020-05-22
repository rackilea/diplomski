abstract class BaseParcelable implements Parcelable {
    private int mX;
    private int mY;

    protected BaseParcelable(int x, int y) {
        mX = x;
        mY = y;
    }

    // Provide a protected constructor that subclasses can call
    // through to initialize all of the saved base class info
    protected BaseParcelable(Parcel in) {
        mX = in.readInt();
        mY = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        // Write out any info in this base class. No CREATOR
        // needs to be provided for this class since it is not
        // instantiable.
        parcel.writeInt(mX);
        parcel.writeInt(mY);
    }
}