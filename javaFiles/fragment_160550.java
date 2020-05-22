// implements Parcelable

public class ResObj implements Parcelable { 
    // ...........your previous code here

    // just simply add the following methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(address);
        dest.writeString(accountName);
        dest.writeString(contactPerson);
        dest.writeString(timeOut);
        dest.writeString(problem);
        dest.writeString(srNo);
        dest.writeString(fieldEngineer);
        dest.writeString(joNo);
        dest.writeString(irNo);
        dest.writeString(designation);
        dest.writeString(email);
        dest.writeString(timeIn);
        dest.writeString(productType);
        dest.writeByte((byte) (status ? 1 : 0));
        dest.writeString(contactNo);
    }
    public static final Parcelable.Creator<ResObj> CREATOR
            = new Parcelable.Creator<ResObj>() {
        public ResObj createFromParcel(Parcel in) {
            return new ResObj(in);
        }

        public ResObj[] newArray(int size) {
            return new ResObj[size];
        }
    };

    protected ResObj(Parcel in) {
        date = in.readString();
        address = in.readString();
        accountName = in.readString();
        contactPerson = in.readString();
        timeOut = in.readString();
        problem = in.readString();
        srNo = in.readString();
        fieldEngineer = in.readString();
        joNo = in.readString();
        irNo = in.readString();
        designation = in.readString();
        email = in.readString();
        timeIn = in.readString();
        productType = in.readString();
        status = in.readByte() != 0;
        contactNo = in.readString();

    }
}