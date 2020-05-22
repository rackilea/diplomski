@Entity
@SequenceGenerator(name = "RECOMMENDATION_SQ", sequenceName = 
"recommendation_sequence")
public class Review {

@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "RECOMMENDATION_SQ")
private Long id;

@ManyToOne
private Restaurant restaurant;

@ManyToOne
private User user;

private Date date;

@Lob
private byte[] image;

private String text;

@OneToOne(fetch = FetchType.LAZY)
@MapsId
@JoinColumn(name = "id")
private Rating rating;