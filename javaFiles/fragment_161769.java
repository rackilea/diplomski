import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class stretch implements Parcelable {

    private Context myContext;
    private Drawable myDrawable;
    private boolean myBoolean;
    private String myString;

    public final static Parcelable.Creator<stretch> CREATOR = new Creator<stretch>() {
        @SuppressWarnings({ "unchecked" })
        public stretch createFromParcel(Parcel in) {
            return new stretch(in);
        }

        public stretch[] newArray(int size) {
            return (new stretch[size]);
        }
    };

    protected stretch(Parcel in) {
        this.myContext = ((Context) in.readValue((Context.class.getClassLoader())));
        this.myDrawable = ((Drawable) in.readValue((Drawable.class.getClassLoader())));
        this.myBoolean = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.myString = ((String) in.readValue((String.class.getClassLoader())));
    }
    public stretch(Context myContext, Drawable myDrawable, boolean myBoolean, String object) {
        this.myContext = myContext;
        this.myDrawable = myDrawable;
        this.myBoolean = myBoolean;
        this.myString = object;
    }

    public Context getMyContext() {
        return myContext;
    }

    public void setMyContext(Context myContext) {
        this.myContext = myContext;
    }

    public Drawable getMyDrawable() {
        return myDrawable;
    }

    public void setMyDrawable(Drawable myDrawable) {
        this.myDrawable = myDrawable;
    }

    public boolean isMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(myContext);
        dest.writeValue(myDrawable);
        dest.writeValue(myBoolean);
        dest.writeValue(myString);
    }

    public int describeContents() {
        return 0;
    }
}