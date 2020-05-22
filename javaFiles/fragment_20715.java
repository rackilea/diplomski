import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.lang.StringUtils;

@Converter(autoApply = true)
public class EmptyStringToNullConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String string) {
        // Use defaultIfEmpty to preserve Strings consisting only of whitespaces
        return StringUtils.defaultIfBlank(string, null);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        //If you want to keep it null otherwise transform to empty String
        return dbData;
    }
}