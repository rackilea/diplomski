public class PlayerEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pla_fk_n_teamId")
    private TeamEntity team;
}