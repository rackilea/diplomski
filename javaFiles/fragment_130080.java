public static final Parcelable.Creator<Parent> CREATOR =
    new Parcelable.Creator<Parent>() {
    public Parent createFromParcel(Parcel in) {

        //read values from Parcel
        int intParam = in.readInt();
        Animal animalParam = in.readParcelable(Animal.class.getClassLoader());
        String stringParam = in.readString();

        //create parent
        Parent parent = new Parent(intParam, animalParam, stringParam);

        return parent;
    }
    public Parent[] newArray(int size) {
        return new Parent[size];
    }
 };