@MessageList("my.config.file.wrapper.type")
public enum Messages implements MessageInfo {

    NO_PERMISSION("no_permission"),
    YOU_DIED("you_died",                "score"),
    PLAYER_LEFT("player_left",          "player_name", "server_name");

    private String key;
    private String[] params;

    Messages(String key, String… params) {
        this.key = key;
        this.params = params;

    @Override
    public String getKey() { return key; }

    @Override
    public String[] getParams() { return params; }

}