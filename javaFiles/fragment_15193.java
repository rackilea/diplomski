public class ParentActivityData implements Parcelable {
    public List<SelectableEntity> listDataHeader;
    public HashMap<String, List<SelectableEntity>> listDataChild;

    public ParentActivityData() {

    }

    private ParentActivityData(Parcel parcel) {
        listDataHeader = (List<SelectableEntity>) parcel.readValue(getClass().getClassLoader());
        listDataChild = (HashMap<String, List<SelectableEntity>>) parcel.readValue(getClass().getClassLoader());
    }

    public static final Parcelable.Creator<ParentActivityData> CREATOR = new Parcelable.Creator<ParentActivityData>() {
        @Override
        public ParentActivityData createFromParcel(Parcel parcel) {
            return new ParentActivityData(parcel);
        }

        @Override
        public ParentActivityData[] newArray(int size) {
            return new ParentActivityData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0xFEED;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeValue(listDataHeader);
        parcel.writeValue(listDataChild);
    }
}


public class SelectableEntity implements Parcelable {
    public SelectableEntity parent = null;
    public String title = null;
    public boolean state = false;
    // Don't use these constructors.
    /*public SelectableEntity(String title) {
        this.title = title;
    }

    public SelectableEntity(SelectableEntity parent, String title) {
        this.parent = parent;
        this.title = title;
    }*/

    public SelectableEntity() {

    }

    // use setters

    public void setParent(SelectableEntity parent) {
        this.parent = parent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    private SelectableEntity(Parcel parcel) {
        parent = parcel.readParcelable(getClass().getClassLoader());
        title = parcel.readString();
        state = (Boolean) parcel.readValue(getClass().getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0xFEED;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeParcelable(parent, flags);
        parcel.writeString(title);
        parcel.writeValue((Boolean)state);
    }

    public static final Parcelable.Creator<SelectableEntity> CREATOR = new Parcelable.Creator<MainActivity.SelectableEntity>() {

        @Override
        public SelectableEntity createFromParcel(Parcel source) {
            return new SelectableEntity(source);
        }

        @Override
        public SelectableEntity[] newArray(int size) {
            return new SelectableEntity[size];
        }
    };
}