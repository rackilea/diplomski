public void writeToParcel(Parcel arg0, int arg1) {
    arg0.writeTypedList(arraylist1); 

    arg0.writeParcelable(object1, arg1);
    arg0.writeParcelable(object2, arg1);
}

public void readFromParcel(Parcel in) {
    arraylist1 = new ArrayList<object3>();
    in.readTypedList(arraylist1, object3.CREATOR);

    object1  = in.readParcelable(object1.class.getClassLoader());
    object2 = in.readParcelable(object2.class.getClassLoader());
}