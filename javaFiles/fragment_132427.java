@Entity
@Table(name = "row_count")
public class RowCount implements Serializable {

   @OneToOne
   @JoinColumn(name = "file_id")
   @MapsId
   private MetaFile file;

   @Id
   @Column(name="file_id")
   private int file_id;

   private int rows;

   public RowCount(MetaFile file, int rows) {
       this.file = file;
       this.rows = rows;
   }
   // getters, setters...

}