import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Scene {
   private  String id;
   private String descrition;

    List<Choice> choices = new ArrayList<Choice>();

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Scene(String id, String descrition) {
        this.id = id;
        this.descrition = descrition;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public String getId() {
        return id;
    }

    public String getDescrition() {
        return descrition;
    }


}