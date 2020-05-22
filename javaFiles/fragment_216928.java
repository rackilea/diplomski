@Entity
@DiscriminatorValue(value="url")
public class Url extends Model{
@ManyToOne
private Domain domain;

private String url;
//getters & setters
}