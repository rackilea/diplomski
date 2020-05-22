@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String email;

private String name;

//bi-directional one-to-one association to Parenttable

@OneToOne(fetch = FetchType.LAZY)
@PrimaryKeyJoinColumn
private Parenttable parenttable;