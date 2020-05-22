public interface Identifiable {

    public UUID getUUID();
}

public interface BetaUser extends Identifiable {

    public boolean isBetaUser();
    public Date    joinedBetaProgramOn();
}