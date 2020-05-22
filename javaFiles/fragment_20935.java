public class Pojo {
    private Root root;

    //general getters, setters and toString
}

public class Root {
    private String status;
    private List<Connection> connections = new ArrayList<>();

    public List<Connection> getConnections() {
        return connections;
    }

    @JsonAnySetter
    public void setConnections(String name, Connection connection) {
        connection.setName(name);
        this.connections.add(connection);
    }

    //other getters, setters and toString
}

public class Connection {
    private String name;
    private String status;

    //general getters, setters and toString
}