@Entity
@NamedQueries({
@NamedQuery(name=Country.QUERY_FIND_BY_NAME,
            query="SELECT c FROM Country c WHERE c.name = :name"),
}) 
public class Country {

    /**
     * Description of the Query. Bla bla.
     */
    public static final String QUERY_FIND_BY_NAME = "Country.findByName";

   ...
}