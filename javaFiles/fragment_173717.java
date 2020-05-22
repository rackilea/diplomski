import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;
import org.codehaus.jackson.map.ser.std.BeanSerializerBase;
import org.codehaus.jackson.node.ObjectNode;
import org.json.JSONException;
import org.json.JSONObject;

public class JacksonModule {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final int COUNT = 0;
    private static final int REPEAT_HEADER = 40;

    static {
        MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
        MAPPER.registerModule(new MyModule());
    }
    private DataProcessor sdp;
    private long[] sum = new long[5];

    public static void main(String[] args) throws IOException, JSONException {
        new JacksonModule().start();
    }

    public JacksonModule() throws IOException, JSONException {
        this.sdp = new DataProcessor();
    }

    public void start() throws IOException, JSONException {
        run(-1, false); // load classes: slow
        if (COUNT > 0) {
            for (int i = 0; i < COUNT; ++i) {
                if (i % REPEAT_HEADER == 0) {
                    System.out.println("---------------------------------------------------------------------------------------");
                    print("", "RO JSONObject", "RO Jackson", "R/- Jackson", "R/W JSONObject", "R/W Jackson");
                    System.out.println("---------------------------------------------------------------------------------------");
                }
                run(i, true);
            }
            System.out.println("-- AVERAGE ----------------------------------------------------------------------------");
            print(1, sum[0] / COUNT, sum[1] / COUNT, sum[2] / COUNT, sum[3] / COUNT, sum[4] / COUNT);
            System.out.println("---------------------------------------------------------------------------------------");
            print("", "RO JSONObject", "RO Jackson", "R/- Jackson", "R/W JSONObject", "R/W Jackson");
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }

    public void run(int i, boolean print) throws JSONException, IOException {
        long t1 = sdp.doReadWithJSONObject();
        long t2 = sdp.doReadWithJackson();
        long t3 = sdp.doReadForUpdatingWithJacksonButDontWrite();
        long t4 = sdp.doSomeWritingWithJSONObject();
        long t5 = sdp.doSomeWritingWithJackson();
        if (print) {
            print(i, t1, t2, t3, t4, t5);
            sum[0] += t1;
            sum[1] += t2;
            sum[2] += t3;
            sum[3] += t4;
            sum[4] += t5;
        }
    }

    private void print(int index, long t1, long t2, long t3, long t4, long t5) {
        print(Integer.toString(index), String.format("%,d", t1), String.format("%,d", t2), String.format("%,d", t3), String.format("%,d", t4), String.format("%,d", t5));
    }

    private void print(String i0, String a, String b, String c, String d, String e) {
        System.out.println("|"
                + StringUtils.leftPad(i0, 5) + "|"
                + StringUtils.leftPad(a, 15) + "|"
                + StringUtils.leftPad(b, 15) + "|"
                + StringUtils.leftPad(c, 15) + "|"
                + StringUtils.leftPad(d, 15) + "|"
                + StringUtils.leftPad(e, 15) + "|");
    }

    private static class DataProcessor {

        private DataStore store;
        private long t0, t1;

        private DataProcessor() throws IOException, JSONException {
            this.store = new DataStore(customer, browser);
        }

        public long doReadWithJSONObject() throws JSONException {
            t0 = System.nanoTime();
            JSONObject json = new JSONObject(store.readData(null)); // can throw JSONException
            JSONObject customer = json.getJSONObject("customer");  // can throw JSONException
            JSONObject browserInfo = json.getJSONObject("browser");  // can throw JSONException
            // need to do manually the mapping and figure out what is exactly in this object. Hell no!
            t1 = System.nanoTime();
            return t1 - t0;
        }

        public long doReadWithJackson() throws IOException {
            t0 = System.nanoTime();
            KnownPart obj = store.readData(null, KnownPart.class);
            t1 = System.nanoTime();
            return t1 - t0;
        }

        public long doReadForUpdatingWithJacksonButDontWrite() throws IOException {
            t0 = System.nanoTime();
            KnownPart obj = store.readDataForUpdating(null, KnownPart.class);
            t1 = System.nanoTime();
            return t1 - t0;
        }

        public long doSomeWritingWithJSONObject() throws JSONException {
            t0 = System.nanoTime();
            JSONObject json = new JSONObject(store.readData(null)); // can throw JSONException
            JSONObject customer = json.getJSONObject("customer");  // can throw JSONException
            JSONObject browserInfo = json.getJSONObject("browser");  // can throw JSONException
            customer.put("name", "Jackson Doe");
            browserInfo.put("version", "10");
            store.saveData(json);
            t1 = System.nanoTime();
            return t1 - t0;
        }

        public long doSomeWritingWithJackson() throws IOException {
            t0 = System.nanoTime();
            KnownPart obj = store.readDataForUpdating(null, KnownPart.class);
            obj.customer.name = "Jackson Doe";
            obj.browser.version = "10";
            store.saveData(obj);
            t1 = System.nanoTime();
            return t1 - t0;
        }
    }

    private static class DataStore {

        private final String data;

        private DataStore(Customer customer, BrowserInfo browser) throws IOException, JSONException {
            StringWriter sw = new StringWriter(1000);
            try (JsonGenerator jgen = MAPPER.getJsonFactory().createJsonGenerator(sw)) {
                jgen.writeStartObject();
                writeBunchOfProperties(jgen);
                jgen.writeFieldName("customer");
                jgen.writeRawValue(MAPPER.writeValueAsString(customer));
                writeBunchOfProperties(jgen);
                jgen.writeFieldName("browser");
                jgen.writeRawValue(MAPPER.writeValueAsString(browser));
                writeBunchOfProperties(jgen);
                jgen.writeEndObject();
            }
            this.data = sw.toString();
        }

        private void writeBunchOfProperties(JsonGenerator jgen) throws IOException {
            int c = new Random().nextInt(3) + 1;
            for (int i = 0; i < c; ++i) {
                jgen.writeFieldName(RandomStringUtils.random(10));
                jgen.writeRawValue(JSON_LONG);
            }
        }

        public String readData(String query) {
            return data;
        }

        private void saveData(String json) {
            // TODO
        }

        public void saveData(JSONObject json) {
            saveData(json.toString());
        }

        public void saveData(Object obj) throws IOException {
            saveData(MAPPER.writeValueAsString(obj));
        }

        public <T> T readData(String query, Class<T> clazz) throws IOException {
            return MAPPER.readValue(readData(query), clazz);
        }

        public <T extends UnknownPart> T readDataForUpdating(String query, Class<T> clazz) throws IOException {
            ObjectNode root = (ObjectNode) MAPPER.readTree(readData(query));
            T obj = MAPPER.readValue(root, clazz);
            obj.tree = root;
            return obj;
        }
    }

    private static abstract class UnknownPart {

         ObjectNode tree;
    }

    private static class KnownPart extends UnknownPart {

        @JsonProperty
        private Customer customer;
        @JsonProperty
        private BrowserInfo browser;
    }

    private static class Customer {

        @JsonProperty
        private int id;
        @JsonProperty
        private String name;
        @JsonProperty
        private Address[] addresses; // just to make it more complex for this example

        public Customer(int id, String name, Address[] addresses) {
            this.id = id;
            this.name = name;
            this.addresses = addresses;
        }

        public Customer() {
        }
    }

    private static class Address {

        @JsonProperty
        private String street;
        @JsonProperty
        private String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        public Address() {
        }
    }

    private static class BrowserInfo {

        @JsonProperty
        private String agent;
        @JsonProperty
        private String version;

        public BrowserInfo(String agent, String version) {
            this.agent = agent;
            this.version = version;
        }

        public BrowserInfo() {
        }
    }

    private static class MyModule extends Module {

        @Override
        public String getModuleName() {
            return "MyModule";
        }

        @Override
        public Version version() {
            return new Version(0, 0, 1, "SNAPSHOT");
        }

        @Override
        public void setupModule(Module.SetupContext context) {
            context.addBeanSerializerModifier(new org.codehaus.jackson.map.ser.BeanSerializerModifier() {
                private UnknownPartSerializer cs;

                @Override
                public JsonSerializer modifySerializer(SerializationConfig config, BasicBeanDescription beanDesc, JsonSerializer<?> serializer) {
                    return UnknownPart.class.isAssignableFrom(beanDesc.getBeanClass())
                       ? new UnknownPartSerializer((BeanSerializerBase) serializer)
                       : serializer;
                }
            });
        }
    }

    private static class UnknownPartSerializer extends BeanSerializerBase {

        public UnknownPartSerializer(BeanSerializerBase src) {
            super(src);
        }

        @Override
        public void serialize(Object bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
            UnknownPart up = (UnknownPart) bean;
            jgen.writeStartObject();
            serializeFields(up, jgen, provider);
            jgen.writeEndObject();
        }

        protected void serializeFields(UnknownPart bean, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
            final BeanPropertyWriter[] props;
            if (_filteredProps != null && provider.getSerializationView() != null) {
                props = _filteredProps;
            } else {
                props = _props;
            }
            int i = 0;
            try {
                for (final int len = props.length; i < len; ++i) {
                    BeanPropertyWriter prop = props[i];
                    if (prop != null) { // can have nulls in filtered list
                        prop.serializeAsField(bean, jgen, provider);
                        bean.tree.remove(prop.getName());
                    }
                }
                if (_anyGetterWriter != null) {
                    _anyGetterWriter.getAndSerialize(bean, jgen, provider);
                }
                Iterator<Entry<String, JsonNode>> it = bean.tree.getFields();
                while (it.hasNext()) {
                    Entry<String, JsonNode> e = it.next();
                    jgen.writeFieldName(e.getKey());
                    jgen.writeObject(e.getValue());
                }
            } catch (Exception e) {
                String name = (i == props.length) ? "[anySetter]"
                        : props[i].getName();
                wrapAndThrow(provider, e, bean, name);
            } catch (StackOverflowError e) {
                /* 04-Sep-2009, tatu: Dealing with this is tricky, since we do not
                 *   have many stack frames to spare... just one or two; can't
                 *   make many calls.
                 */
                JsonMappingException mapE = new JsonMappingException("Infinite recursion (StackOverflowError)", e);
                String name = (i == props.length) ? "[anySetter]"
                        : props[i].getName();
                mapE.prependPath(new JsonMappingException.Reference(bean, name));
                throw mapE;
            }
        }
    }
    private static Customer customer = new Customer(1, "John Doe", new Address[]{
        new Address("broadway av", "new york"),
        new Address("peachtree st", "atlanta")
    });
    private static BrowserInfo browser = new BrowserInfo("IE", "6.0");
    // some json found on the internet
    private static final String JSON_LONG = "{\"web-app\": {"
            + "\"servlet\": ["
            + "{"
            + "\"servlet-name\": \"cofaxCDS\","
            + "\"servlet-class\": \"org.cofax.cds.CDSServlet\","
            + "\"init-param\": {"
            + "\"configGlossary:installationAt\": \"Philadelphia, PA\","
            + "\"configGlossary:adminEmail\": \"ksm@pobox.com\","
            + "\"configGlossary:poweredBy\": \"Cofax\","
            + "\"configGlossary:poweredByIcon\": \"/images/cofax.gif\","
            + "\"configGlossary:staticPath\": \"/content/static\","
            + "\"templateProcessorClass\": \"org.cofax.WysiwygTemplate\","
            + "\"templateLoaderClass\": \"org.cofax.FilesTemplateLoader\","
            + "\"templatePath\": \"templates\","
            + "\"templateOverridePath\": \"\","
            + "\"defaultListTemplate\": \"listTemplate.htm\","
            + "\"defaultFileTemplate\": \"articleTemplate.htm\","
            + "\"useJSP\": false,"
            + "\"jspListTemplate\": \"listTemplate.jsp\","
            + "\"jspFileTemplate\": \"articleTemplate.jsp\","
            + "\"cachePackageTagsTrack\": 200,"
            + "\"cachePackageTagsStore\": 200,"
            + "\"cachePackageTagsRefresh\": 60,"
            + "\"cacheTemplatesTrack\": 100,"
            + "\"cacheTemplatesStore\": 50,"
            + "\"cacheTemplatesRefresh\": 15,"
            + "\"cachePagesTrack\": 200,"
            + "\"cachePagesStore\": 100,"
            + "\"cachePagesRefresh\": 10,"
            + "\"cachePagesDirtyRead\": 10,"
            + "\"searchEngineListTemplate\": \"forSearchEnginesList.htm\","
            + "\"searchEngineFileTemplate\": \"forSearchEngines.htm\","
            + "\"searchEngineRobotsDb\": \"WEB-INF/robots.db\","
            + "\"useDataStore\": true,"
            + "\"dataStoreClass\": \"org.cofax.SqlDataStore\","
            + "\"redirectionClass\": \"org.cofax.SqlRedirection\","
            + "\"dataStoreName\": \"cofax\","
            + "\"dataStoreDriver\": \"com.microsoft.jdbc.sqlserver.SQLServerDriver\","
            + "\"dataStoreUrl\": \"jdbc:microsoft:sqlserver://LOCALHOST:1433;DatabaseName=goon\","
            + "\"dataStoreUser\": \"sa\","
            + "\"dataStorePassword\": \"dataStoreTestQuery\","
            + "\"dataStoreTestQuery\": \"SET NOCOUNT ON;select test='test';\","
            + "\"dataStoreLogFile\": \"/usr/local/tomcat/logs/datastore.log\","
            + "\"dataStoreInitConns\": 10,"
            + "\"dataStoreMaxConns\": 100,"
            + "\"dataStoreConnUsageLimit\": 100,"
            + "\"dataStoreLogLevel\": \"debug\","
            + "\"maxUrlLength\": 500}},"
            + "{"
            + "\"servlet-name\": \"cofaxEmail\","
            + "\"servlet-class\": \"org.cofax.cds.EmailServlet\","
            + "\"init-param\": {"
            + "\"mailHost\": \"mail1\","
            + "\"mailHostOverride\": \"mail2\"}},"
            + "{"
            + "\"servlet-name\": \"cofaxAdmin\","
            + "\"servlet-class\": \"org.cofax.cds.AdminServlet\"},"
            + ""
            + "{"
            + "\"servlet-name\": \"fileServlet\","
            + "\"servlet-class\": \"org.cofax.cds.FileServlet\"},"
            + "{"
            + "\"servlet-name\": \"cofaxTools\","
            + "\"servlet-class\": \"org.cofax.cms.CofaxToolsServlet\","
            + "\"init-param\": {"
            + "\"templatePath\": \"toolstemplates/\","
            + "\"log\": 1,"
            + "\"logLocation\": \"/usr/local/tomcat/logs/CofaxTools.log\","
            + "\"logMaxSize\": \"\","
            + "\"dataLog\": 1,"
            + "\"dataLogLocation\": \"/usr/local/tomcat/logs/dataLog.log\","
            + "\"dataLogMaxSize\": \"\","
            + "\"removePageCache\": \"/content/admin/remove?cache=pages&id=\","
            + "\"removeTemplateCache\": \"/content/admin/remove?cache=templates&id=\","
            + "\"fileTransferFolder\": \"/usr/local/tomcat/webapps/content/fileTransferFolder\","
            + "\"lookInContext\": 1,"
            + "\"adminGroupID\": 4,"
            + "\"betaServer\": true}}],"
            + "\"servlet-mapping\": {"
            + "\"cofaxCDS\": \"/\","
            + "\"cofaxEmail\": \"/cofaxutil/aemail/*\","
            + "\"cofaxAdmin\": \"/admin/*\","
            + "\"fileServlet\": \"/static/*\","
            + "\"cofaxTools\": \"/tools/*\"},"
            + ""
            + "\"taglib\": {"
            + "\"taglib-uri\": \"cofax.tld\","
            + "\"taglib-location\": \"/WEB-INF/tlds/cofax.tld\"}}}";
}