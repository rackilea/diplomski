@Entity
@SequenceGenerator(name = "RATING_SQ", sequenceName = "rating_sequence")
public class Rating {

@Id
@GeneratedValue
private Long id;

private int dish;
private int service;
private int price;
private int location;
private int accessibility;