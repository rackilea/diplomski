@Projection(name = "noPlayers", types = { Team.class })
public interface TeamWithoutPlayers {

    Long getId();
    long getTeamId();
    String getAbbreviation();
    String getTeam();
    String getSimpleName();
    String getLogo();
}