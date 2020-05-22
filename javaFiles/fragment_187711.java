@MappedSuperclass
public class PersistentObject {

    @Id // Put all your ID mapping here
    private Long id;

    @Version
    private Long version;

}

@Entity
public class SimpsonsFamily extends PersistentObject {        
    // Other SimpsonFamily-specific fields here, with their mappings    
}