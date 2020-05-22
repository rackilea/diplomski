import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "region",
       indexes = {@Index(name = "my_index_name",  columnList="iso_code", unique = true),
                  @Index(name = "my_index_name2", columnList="name",     unique = false)})
public class Region{

    @Column(name = "iso_code", nullable = false)
    private String isoCode;

    @Column(name = "name", nullable = false)
    private String name;

}