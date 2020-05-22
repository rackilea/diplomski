public class ParentIdAdapter extends XmlAdapter<ParentIdAdapter.AdaptedParentId, String> {

    public String unmarshal(AdaptedParentId value) {
        return value.id;
    }

    public AdaptedParentId marshal(String value) {
        AdaptedParentId adapted = new AdaptedParentId();
        adapted.id = value;
        return adapted;
    }

    public static class AdaptedParentId {
        @XmlAttribute
        public String id;
    }

}