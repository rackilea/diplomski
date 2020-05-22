@Component
@ConfigurationPropertiesBinding
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(soruce);
    }
}