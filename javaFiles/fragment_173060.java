public class BEntity implements Serializable{

    @Id
    private PKClass pkClass = null;

    @Column(name = "V_CNT")
    private Integer vcnt;

   //{{{some column omitted}}}//
}

public class AEntity implements Serializable{

    @Id
    private PKClass pkClass = null;

    @OneToOne
    @PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name="NUM", referencedColumnName="NUM"),
        @PrimaryKeyJoinColumn(name="INIT", referencedColumnName="INIT")
    })
    private BEntity bEntity;
}