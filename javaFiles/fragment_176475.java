public class MessagerieInterne implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String sujet;

@ManyToOne(optional = false)
@JoinColumn(name = "ID_EXPEDITEUR", nullable = false)
private Utilisateur expediteur;

@ManyToOne(optional = false)
@JoinColumn(name = "ID_DESTINATAIRE", nullable = false)
private Utilisateur destinataire;