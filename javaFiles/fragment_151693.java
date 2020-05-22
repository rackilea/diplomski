import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Gson gson = new GsonBuilder().create();

        System.out.println("Use generic Map");
        Type genericMapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> map = gson.fromJson(new FileReader(jsonFile), genericMapType);
        map.forEach((k, v) -> System.out.println(k + " => " + v));

        System.out.println();
        System.out.println();

        System.out.println("Use Service Map");
        Type serviceMapType = new TypeToken<Map<String, Service>>() {
        }.getType();
        Map<String, Service> serviceMap = gson.fromJson(new FileReader(jsonFile), serviceMapType);
        serviceMap.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}

class Service {
    private List<String> addresses;

    @SerializedName("healthcheck_interval")
    private int healthCheckInterval;
    private String http;
    private int port;

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public int getHealthCheckInterval() {
        return healthCheckInterval;
    }

    public void setHealthCheckInterval(int healthCheckInterval) {
        this.healthCheckInterval = healthCheckInterval;
    }

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Service{" +
                "addresses=" + addresses +
                ", healthCheckInterval=" + healthCheckInterval +
                ", http='" + http + '\'' +
                ", port=" + port +
                '}';
    }
}