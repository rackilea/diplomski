import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

    @ApplicationPath("/test")
    public class YourApplication extends ResourceConfig {
        public YourApplication() {
            this.packages("insert.packagename.where.your.class.is.here");
        }
    }