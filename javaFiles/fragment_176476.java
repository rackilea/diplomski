public class Utilisateur implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;

@OneToMany(mappedBy = "expediteur")
private List<MessagerieInterne> messagesEnvoyes;

@OneToMany(mappedBy = "destinataire")
private List<MessagerieInterne> messagesRecus;