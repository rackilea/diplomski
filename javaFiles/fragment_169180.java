@Entity
@IdClass(value=ClassAB.ClassABId.class)
public class ClassAB implements Serializable {
    private String idA;
    private String idB;

    @Id
    @Column(name="ID_A")
    public String getIdA(){ return idA; }
    public void setIdA(String idA){ this.idA = idA; }

    @Id
    @Column(name="ID_B")
    public String getIdB(){ return idB; }
    public void setIdB(String idB){ this.idB = idB; }

    static class ClassABId implements Serializable {
        private String idA;
        private String idB;

        public String getIdA(){ return idA; }
        public void setIdA(String idA){ this.idA = idA; }

        public String getIdB(){ return idB; }
        public void setIdB(String idB){ this.idB = idB; }

        // implement equals(), hashcode()
    }
}