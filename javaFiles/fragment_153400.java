public class Details {
    public String name;  // example property

    @JsonCreator
    public static Details factory(Map<String,Object> props) {

        if (props.get("details") instanceof Boolean) return null;

        Details details = new Details();
        Map<String,Object> detailsProps = (Map<String,Object>)props.get("details");
        details.name = (String)detailsProps.get("name");
        return details;
    }
}