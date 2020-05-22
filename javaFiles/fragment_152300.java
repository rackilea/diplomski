public class BulkDTOWrapper {

    private List<BulkDTO> bulks;

    @JsonCreator
    public BulkDTOWrapper(List<BulkDTO> bulks) {
        this.bulks = bulks;
    }

    public BulkDTOWrapper() {
    }

    @JsonValue
    public List<BulkDTO> getBulks() {
        return bulks;
    }

    public void setBulks(List<BulkDTO> bulks) {
        this.bulks = bulks;
    }

    public static void main(String[] args) throws IOException {
        BulkDTO b1 = new BulkDTO("hello");
        BulkDTO b2 = new BulkDTO("world");

        BulkDTOWrapper wrapper = new BulkDTOWrapper();
        wrapper.setBulks(Arrays.asList(b1, b2));

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(wrapper);
        System.out.println("json = " + json);

        BulkDTOWrapper wrapper2 = om.readValue(json, BulkDTOWrapper.class);
        System.out.println(wrapper2.getBulks().size());
    }
}