@Entity
  @IdClass(TournamentPk.class)
  public class Tournament {

    @Id
    @Column(name="player_id", insertable = false, updatable = false)
    private Long playerId;

    @ManyToOne
    @JoinColumn("player_id")//consider adding cascade=PERSIST
    private Player player;  

    @Id
    @Column(name="game_id", insertable = false, updatable = false)
    private Long gameId;

    @ManyToOne
    @JoinColumn("game_id")//consider adding cascade=PERSIST
    private Game game;
    private int score;

    // Getters and Setters
    // Hashcode and Equals
}

  public class TournamentPk {

    private Long playerId;
    private Long gameId;

    // Getters and Setters
    // Hashcode and Equals
 }