@Entity
@Table(name="VW_TABLE_B")
public class B {

    @Id
    @Column(name = "id_B", length = 14)
    private String id;

    @Column(name = "col_B")
    private String colB;

    protected void setId(String id){
        this.id = id;
   }
}