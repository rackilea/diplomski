package forum9906642;

import java.net.URI;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlAccessorType(XmlAccessType.FIELD)
class Child {

    @XmlAttribute(name="someAttribute")
    @XmlJavaTypeAdapter(UriAdapter.class)
    private URI _someAttribute;

    public URI getSomeAttribute() {
        return _someAttribute;
    }

    public void setSomeAttribute(URI _someAttribute) {
        this._someAttribute = _someAttribute;
    }

}