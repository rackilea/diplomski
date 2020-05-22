import java.util.ArrayList;
import java.util.Collection;

public class PropertyList extends ArrayList<Property> {

private static final long serialVersionUID = -7854888805136619636L;

    PropertyList(){
        super();
    }

    PropertyList(Collection<Property> c){
        super(c);
    }

    boolean containsProperty(PropertyList<Property> pl){
        Property asdf = (Property) this.get(4);
        System.out.println(asdf.<can't access "Property" methods>);  //mark
        return false;
    }

}