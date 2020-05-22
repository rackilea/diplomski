@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private int num;

//bi-directional one-to-one association to Childtable
@OneToOne(fetch = FetchType.LAZY, mappedBy = "parenttable", cascade = CascadeType.ALL)
private Childtable childtable;