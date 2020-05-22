@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idTache;

@ManyToOne
@JoinColumn(name="idTache")
private Tache tacheParente;