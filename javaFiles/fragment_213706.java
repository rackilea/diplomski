public static final Parcelable.Creator<SavedState> CREATOR
        = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {

    @Override
    public SavedState createFromParcel(Parcel in, ClassLoader loader) {
        return new SavedState(in, loader);
    }

    @Override
    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }

});