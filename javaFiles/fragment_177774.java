public final class ParcelableImpl extends BaseParcelable {
    private int mZ;

    public ParcelableImpl(int x, int y, int z) {
        super(x, y);
        mZ = z;
    }

    // Have a constructor taking a parcel that you can use
    // to pass the parcel to the superclass
    private ParcelableImpl(Parcel in) {
        super(in);
        mZ = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        // Make sure to call through to super so that BaseParcelable
        // writes out its data first, then write additional data 
        // specific to this class implementation
        super.writeToParcel(parcel, i);
        parcel.writeInt(mZ);
    }

    // This class *does* need a creator since it's an instantiable class
    public static final Creator<ParcelableImpl> CREATOR = new Creator<ParcelableImpl>() {
        @Override
        public ParcelableImpl createFromParcel(Parcel parcel) {
            // Pass the Parcel into your Parcel constructor
            return new ParcelableImpl(parcel);
        }

        @Override
        public ParcelableImpl[] newArray(int size) {
            return new ParcelableImpl[size];
        }
    };
}