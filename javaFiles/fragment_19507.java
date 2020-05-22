package forum12295028;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;

class JAXB2ValidationEventCollector extends ValidationEventCollector {

    @Override
    public boolean handleEvent(ValidationEvent event) {
        super.handleEvent(event);
        return true;
    }

}