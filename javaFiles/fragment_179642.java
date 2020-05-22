@Entity
@Table(name="ACCOUNT")
public class Account {
    @Id @GeneratedValue @Column(name="a_id") private long id;

    @OneToMany
    @OrderColumn(name="idx")
    private List<OrderLine> orderLines;

    // other stuff
}

@Entity
@Table(name="ORDERLINE")
public class OrderLine {
    @Id @GeneratedValue @Column(name="ol_id") private long id;

    // other stuff
}