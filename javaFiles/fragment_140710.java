public class JacksonBeanToArray {
    public static class Search {
        public List<Double> minLatLng=new ArrayList<Double>();
        public List<Double> maxLatLng=new ArrayList<Double>(); //These are bounding co-ordinates
        public List<Integer> ids=new ArrayList<Integer>();
        public List<Integer> owner=new ArrayList<Integer>();
        public float minScore;
        public float maxScore;
        public long minLength;
        public long maxLength;
        public String flag;
        public String language;
        public String keywords;
        public List<Integer> groupIds=new ArrayList<Integer>();
        public List<Integer> characteristic=new ArrayList<Integer>();
        public List<Integer> theme=new ArrayList<Integer>();
        public boolean acitivity;
        public List<Integer> activityOwner=new ArrayList<Integer>();
        public boolean event;
        public List<Integer> eventOwner=new ArrayList<Integer>();
        public List<Integer> favouriteUser=new ArrayList<Integer>();

        @JsonValue
        public Map<String, Object[]> getAsParamMap() throws IllegalAccessException {
            Object[] result = new Object[getClass().getFields().length];
            for (int i = 0; i < result.length; i++) {
                result[i] = getClass().getFields()[i].get(this);
            }
            return Collections.singletonMap("params", result);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Search search = new Search();
        search.acitivity = true;
        search.maxLatLng = Arrays.asList(0.44, 5.);
        search.maxScore = 4;
        search.language = "EN";
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(search));
    }

}