@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class City extends AbstractEntity {

@Column
private String name;

@Embedded
private Geopoint centre=new Geopoint();

public City(){}
public City(String name){
    this.setName(name);
    }
//  @OneToMany(mappedBy="city")
//  private Set<Place> places;

}