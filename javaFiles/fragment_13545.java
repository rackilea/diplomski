import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ParcelableEntity implements Parcelable {
    private static final String TAG = "ParcelableEntity";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {

        destination.writeString(this.getClass().getCanonicalName());

        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.getType().equals(java.util.List.class)) {
                    destination.writeList((ArrayList) field.get(this));
                } else
                    destination.writeValue(field.get(this));
            } catch (Exception err) {
                Log.w(TAG, err.toString());
            }

        }

    }

    public static final Creator CREATOR = new Creator() {
        public ParcelableEntity createFromParcel(Parcel source) {
            try {
                Object entity = Class.forName((source.readString())).newInstance();

                for (Field field : entity.getClass().getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        if (field.getType().equals(java.util.List.class)) {
                            ArrayList list = new ArrayList();
                            source.readList(list, Class.forName(field.getDeclaringClass().getName()).getClassLoader());
                            field.set(entity, list);
                        } else
                            field.set(entity, source.readValue(field.getType().getClassLoader()));

                    } catch (Exception err) {
                        Log.w(TAG, err.toString());
                    }
                }

                return (ParcelableEntity) entity;

            } catch (Exception err) {
                return null;
            }
        }

        public ParcelableEntity[] newArray(int size) {
            return new ParcelableEntity[size];
        }
    };

}