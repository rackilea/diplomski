public class MappingUtil {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Ip {
    }
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Server {
    }
    @Ip
    public String ip(Map<String, Object> in) {

        return (String)in.get("ip");
    }
    @Server
    public String server(Map<String, Object> in) {

        return (String)in.get("server");
    }
}