public class UserProfile implements Serializable {

///////////////////////////////////////////////////////////////////////////
//private variables
private String profileName = null;
private int version = 0;
private LeaderboardPermissions leaderboardState = LeaderboardPermissions.ASK;
private boolean upgradeWalkThrough = true;
private final Map<GameType, GameTypeStats> gameTypeStats;
private final String id;
private boolean offNet = true;

///////////////////////////////////////////////////////////////////////////
//serialization stuff
private static final long serialVersionUID = 7625672295622776890L;

private UserProfile(UserProfileProxy t) {
    this.profileName = t.profileName;
    this.version = t.version;
    this.leaderboardState = t.leaderboardState;
    this.upgradeWalkThrough = t.upgradeWalkThrough;
    this.gameTypeStats = t.gameTypeStats;
    this.id = t.id;
    this.offNet = t.offNet;
}

private Object writeReplace() {
    return new UserProfileProxy(this);
}

private void readObject(ObjectInputStream stream)
        throws InvalidObjectException {
    throw new InvalidObjectException("Proxy required");

}

///////////////////////////////
//serialization proxy
private static class UserProfileProxy implements Serializable {

    private String profileName = null;
    private int version = 0;
    private final LeaderboardPermissions leaderboardState;
    private boolean upgradeWalkThrough = true;
    private final Map<GameType, GameTypeStats> gameTypeStats;
    private String id;
    private static final long serialVersionUID = 6985672045622776890L;
    private boolean offNet;

    private UserProfileProxy(UserProfile t) {
        this.profileName = t.profileName;
        this.version = t.version;
        this.leaderboardState = t.leaderboardState;
        this.upgradeWalkThrough = t.upgradeWalkThrough;
        this.gameTypeStats = t.gameTypeStats;
        this.id = t.id;
        this.offNet = t.offNet;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
    }

    private Object readResolve() throws ObjectStreamException {
        return new UserProfile(this);
    }

}