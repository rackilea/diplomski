public class Classification {
    String classification;
    long id;
    public Classification (String classification,long id) {
        this.Classification = classification;
        this.id = id;
    }
} 

String SQLCOMMAND
            = "SELECT new full.package.path.to.Classification( d.classification, d.fk_projectdoc_id) " + "FROM "
            + ProjectDocs.class.getSimpleName() + " d "
            + " WHERE d.fk_projectdoc_id = ?1";