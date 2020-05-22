import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Field;
import java.util.Comparator;

public class MyComprator implements Comparator<DTOObject> {

    private JsonArray params;

    public MyComprator(JsonArray params) {
        this.params = params;
        // TODO: Here possible to sort params by 'sequence' if needed
    }

    @Override
    public int compare(DTOObject o1, DTOObject o2) {
        for (int i = 0; i < params.size(); i++) {
            JsonObject param = params.get(i).getAsJsonObject();
            String fieldName = param.get("name").getAsString();
            String datatype = param.get("datatype").getAsString();
            int order = param.get("order").getAsString().equals("asc") ? 1 : -1;

            int compare = 0;

            if (datatype.equals("String")) {
                 compare = getField(o1, fieldName, String.class).compareTo(
                               getField(o2, fieldName, String.class));
            }
            else if (datatype.equals("int")) {
                compare = getField(o1, fieldName, Integer.class).compareTo(
                          getField(o2, fieldName, Integer.class));
            }

            if (compare != 0) {
                return compare * order;
            }
        }

        return 0;
    }

    private <T> T getField(DTOObject obj, String fieldName, Class<T> type) {
        try {
            // Use refelction
            Field field = DTOObject.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(obj);
            return (T) value;
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            // TODO: Handle exception
            return null;
        }
    }
}