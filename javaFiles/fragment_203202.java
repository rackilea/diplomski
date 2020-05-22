private final Integer port;
private final String serverName;
private final String serverType;
private final String listenerType;



private BootServer(Builder builder) {// step #2 create private constructor
    this.port = builder.port;
    this.serverName = builder.serverName;
    this.serverType = builder.serverType;
    this.listenerType=builder.listenerType;

}

 public static Builder builder() {//Step#3 create static builder method to return Builder
        return new Builder();
    }

public static final class Builder {//Step#4 create public static builder class

    private Integer port;
    private String serverName;
    private String serverType;
    private String listenerType;

    private Builder(){

    }
    public BootServer build() {//Step#5 create build method to return BootServer Object with this object
        return new BootServer(this);
    }


    public Builder addServerPort(Integer port) {//Step#6 finally create all build method to set values to main class 
        this.port=port;
        return this;
    }


    public Builder addServerName(String name) {
        this.serverName=name;
        return this;
    }

    public Builder setServerType(String serverType) {
        this.serverType=serverType;
        return this;
    }

    public Builder setListenerType(String listenerType) {
        this.listenerType=listenerType;
        return this;
    }

}

@Override
public String toString() {
    return "BootServer [port=" + port + ", serverName=" + serverName + ", serverType=" + serverType
            + ", listenerType=" + listenerType + "]";
}