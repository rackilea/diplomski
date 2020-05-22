public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR 
        = new Parcelable.ClassLoaderCreator<SavedState>() {

    @Override
    public SavedState createFromParcel(Parcel source) {
        return createFromParcel(source, null);
    }

    @Override
    public SavedState createFromParcel(Parcel source, ClassLoader loader) {
        return new SavedState(source, loader);
    }

    @Override
    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
};