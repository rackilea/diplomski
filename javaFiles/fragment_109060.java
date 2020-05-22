@XmlType
public class Type1{

    private List<RelationCanonical> relations;

    @XmlElement
    public List<RelationCanonical> getRelations(){
        return this.relations;
    }

    public void setRelations(List<RelationCanonical> relations){
        this.relations = relations;
    }
}