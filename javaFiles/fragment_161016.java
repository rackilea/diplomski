import play.db.jpa.Model;

// should import javax.persistence.* package rather than org.hibernate.*
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Media extends Model {
   ....
}