public class Players {

...

@ManyToMany(mappedBy="players", fetch=FetchType.LAZY)
private List<Teams> teams;

...

}

public class Teams {

...

@ManyToMany(fetch=FetchType.LAZY)
@JoinTable(name="player_team", joinColumns={@JoinColumn(name="TEAM_ID")}, inverseJoinColumns={@JoinColumn(name="PLAYER_ID")})
private list<Players> players;

...

}