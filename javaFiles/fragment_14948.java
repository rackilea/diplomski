public class ImageItems implements Parcelable {
    private String mYourString;
    // Your BITMAP implementation.

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        // Break down your object here for storage into the parcel.
        out.writeString(mYourString);
        // Write your BITMAP to the parcel.
    }

    public static final Parcelable.Creator<ImageItems> CREATOR
         = new Parcelable.Creator<ImageItems>() {
            public ImageItems createFromParcel(Parcel in) {
                return new ImageItems(in);
            }

            public ImageItems[] newArray(int size) {
                return new ImageItems[size];
            }     
   };

   private ImageItems(Parcel in) {
       // Rebuild your object from the parcel here.
       mYourString = in.readString();
       // Read your BITMAP from the parcel.
   }
}