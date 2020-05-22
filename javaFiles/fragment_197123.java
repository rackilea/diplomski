import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.mvel2.MVEL;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class RoleStatusDeserializer implements JsonDeserializer<RoleStatus> {

    @Override
    public RoleStatus deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        // get roleStatus from jsonObject and populate new roleStatus object
        final RoleStatus roleStatus = new RoleStatus(jsonObject.get("roleStatus").getAsString());

        final String expression = getFiledAnnotationValue();
        // Evaluate expression via Mvel.
        final String result = (String) MVEL.eval(expression, roleStatus);
         // update statusRole
        roleStatus.setRoleStatus(result);

        return roleStatus;
    }

    /**
     * reading Filed level annotation via java reflection
     * @return annoation value
     */
    private String getFiledAnnotationValue() {

        String expression = null;
        for (Field field : RoleStatus.class.getDeclaredFields()) {

            final Annotation annotation = field.getAnnotation(Convertor.class);

            if (annotation instanceof Convertor) {
                field.setAccessible(true);
                Convertor convertorAnnotation = (Convertor) annotation;
                expression = convertorAnnotation.expression();
                field.setAccessible(false);
            }
        }

        return expression;
    }
}