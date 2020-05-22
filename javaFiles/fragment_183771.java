public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    private Projet projet;
    private Tache tache;
    private Activite activite;
    private Phase phase;
    private String nameProjet;

    public Document(Object obj) {
        if (obj instanceof Phase) {
            phase = (Phase)obj;
        }else if (obj instanceof Activite) {
            activite = (Activite)obj;
        }else if (obj instanceof Tache) {
            tache = (Tache)obj;
        }else{
            projet = (Projet)obj;
        }
    }

//gets and sets
}