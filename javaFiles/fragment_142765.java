import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PositionConverter implements AttributeConverter<Position, String> {

    @Override
    public String convertToDatabaseColumn(Position attribute) {
        return attribute.getName();
    }

    @Override
    public VolleyballPlayerPosition convertToEntityAttribute(String dbData) {
        return Position.from(dbData);
    }
}