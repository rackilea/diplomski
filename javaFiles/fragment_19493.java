@ManyToOne
@JoinColumn(name="MATCH_ID", insertable = false, updatable = false)
private Match match;

@ManyToOne
@JoinColumn(name="PLAYER_ID", insertable = false, updatable = false)
private Player player;