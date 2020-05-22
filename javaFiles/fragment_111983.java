import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlAccessorType(XmlAccessType.FIELD)
public class AccidentName {

    @XmlInverseReference(mappedBy = "occupants")
    private AccidentVehicle m_accidentVehicleRecord;

    public AccidentVehicle getAccidentVehicleRecord() {
        return m_accidentVehicleRecord;
    }

}