import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author jadlr
 */
public class UserConnected {

private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

private final int event;
private final String cookie;
private final From from;
private final Channel channel;

public UserConnected(int event, String cookie, From from, Channel channel) {
    this.from = from;
    this.cookie = cookie;
    this.event = event;
    this.channel = channel;
}

public int getEvent() {
    return event;
}

public String getCookie() {
    return cookie;
}

public From getFrom() {
    return from;
}

public String toJson() {
    return GSON.toJson(this, UserConnected.class);
}

public static class From {

    private final int id;
    private final String userId;

    public From(int id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

}

public static class Channel {

    private final int id;
    private final String name;

    public Channel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

public static void main(String[] args) {

    UserConnected userConnected = new UserConnected(0, "cookie123", new From(1, "user"), new Channel(1, "channel"));
    System.out.println(userConnected.toJson());

}

}