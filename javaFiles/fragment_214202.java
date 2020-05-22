public class City {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="CITY_ID")
private Long id;

@Column(name="CITY_NAME",length=20,nullable=false,unique=false)
private String cityName;

@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
@JoinColumn(name="COUNTRY_ID",nullable=false)
private Country country;
}