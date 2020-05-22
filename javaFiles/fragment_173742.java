@Slf4j
public class YearMonthStringTest {

    public static final String json = 
            "[\n"
            + "  \"2017-12\", \n"
            + "  \"2018-01\", \n"
            + "  \"2018-02\", \n"
            + "  \"2018-03\" \n"
            + "]";

    @Test
    public void fromJsonTest() {
        String[] strs = new Gson().fromJson(json, String[].class);
        Arrays.asList(strs).forEach(str -> {
            log.info("{}", str);
        });
    }

    @Test
    public void toJsonTest() {
        String[] str = new String[] { "2001-01", "1984-02"
                                    , "1878-11", "0000-12" };
        String jsonFromArray = new GsonBuilder()
                .setPrettyPrinting().create().toJson(str);
        log.info("json from array:\n{}", jsonFromArray);
    }

}