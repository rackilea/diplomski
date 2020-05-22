@Entity
public class Data{
private int id;
@ManyToOne
private Model model;
}