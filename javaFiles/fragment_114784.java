@Entity
public class ATable {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "btable_id")
    private BTable b;

    @ManyToOne
    @JoinColumn(name = "atable_main_id")
    private ATable main;
}

@Entity
public class BTable {

    @Id
    private Long id;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "atable_main_id")
    private ATable main;
}