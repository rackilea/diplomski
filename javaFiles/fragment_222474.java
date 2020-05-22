public class MapperUtils {
    @FirstElement
    public String firstEmailAddress(List<Person> in) {
        if (in != null && !in.isEmpty()) {
            return in.get(0).getEmailAddress();
        }
        else {
            return null;
       }
    }
}