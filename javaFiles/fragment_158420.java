Example:
@Entity
@Table(name="transformations_ s3files")
public class Relation extends Model {
    @Id
    public Long id;

    @ManyToOne
    public Transformation transformation;        

    @OneToOne
    public S3File file;
}