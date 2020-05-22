@Data
public class Team {
    @OneToMany(mappedBy = "team")
    @ToString.Exclude
    private List<Player> players;
}