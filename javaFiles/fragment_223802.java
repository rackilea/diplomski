import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class PhoneConverter implements Converter<Map<PhoneType, String>, List<Phone>>{

    public List<Phone> convert(Map<PhoneType, String> phonesMap) {
        List<Phone> phones = new ArrayList<Phone>();
        for (PhoneType phoneType : phonesMap.keySet()) {
            phones.add(new Phone(phoneType, phonesMap.get(phoneType)));
        }
        return phones;
    }

    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructMapLikeType(Map.class, PhoneType.class, String.class);
    }

    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructCollectionLikeType(List.class, Phone.class);
    }
}