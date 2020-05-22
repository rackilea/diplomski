@Entity
@IdClass(Entity1Entity2Pk.class)
public class Entity1Entity2 {

    @ManyToOne
    @Id
    private Entity1 entity1;

    @ManyToOne
    @Id
    private Entity2 entity2;

    ...    
}