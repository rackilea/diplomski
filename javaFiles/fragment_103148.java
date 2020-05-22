public enum Person
{
    FRED("Frederick", "Fred"),
    PETE("Peter", "Pete"),
    MALCOLM("Malcolm"); // No nickname

    private final String nickname;
    private final String name;

    private Person(String name, String nickname)
    {
        this.name = name;
        this.nickname = nickname;
    }

    private Person(String name)
    {
        this(name, name); // Just use the name as the nickname too
    }

    // getNickname and getName
}