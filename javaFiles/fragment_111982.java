import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccidentVehicle {

    @XmlElementWrapper( name="Occupants" )
    @XmlElements( @XmlElement( name="AccidentName" ) )
    private Set<AccidentName> m_occupants = new HashSet<AccidentName>();

    public Set<AccidentName> getOccupants() {
        return m_occupants;
    }

}