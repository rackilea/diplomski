@XmlRootElement(name="ACCESREFUSE")
public class ACCESREFUSE {

    protected String v1;
    protected String v2;
    protected String v3;
    protected String v4;
    protected String v5;
    protected String v6;
    protected String v7;
        protected String v8;
    protected String v9;
    protected String CauseRefus;
    protected TypeRefus typeRefus;

     public enum TypeRefus{
         DelaiIdentite, RejetIdentite, Interdit, AutoInterdit, OpVerrouille, Verrouille, Cloture, Autre;
    }