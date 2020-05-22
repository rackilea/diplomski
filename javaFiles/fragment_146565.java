package pojos;

import com.google.auto.value.AutoValue;
import org.apache.poi.ss.usermodel.Row;

import java.util.Map;

@AutoValue
public abstract class RowMapHolder {

    public abstract Row row();

    public abstract Map<Integer,String> mapping();

    public static RowMapHolder create(Row row, Map<Integer, String> mapping) {
        return new AutoValue_RowMapHolder(row, mapping);
    }

}