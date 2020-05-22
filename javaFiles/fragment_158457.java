//private List<Alias> listalias;

import io.ebean.Finder;

@Entity
@Table(name = "alias")
public class Alias extends Model 
{
    @Id
    public Long id;

    @Constraints.Required
    @Formats.NonEmpty
    public String name;

    @ManyToOne
    public Parameters parameters;  

    // This List will take Json as Object Model
    private List<Alias> listalias;


    public static final Finder<Long, Alias> find = new Finder<>(Alias.class);



}