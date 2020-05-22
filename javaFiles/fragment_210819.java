@Entity
public class Game {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlayer")
    private Player idPlayer;

}