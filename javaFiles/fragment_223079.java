import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="someRandomElement")
class SomeRandomClass {

    private XPathFragment _expression;

    @XmlAttribute(name="xpath")
    @XmlJavaTypeAdapter(XPathFragmentAdapter.class)
    public XPathFragment get_expression() {
        return _expression;
    }

    public void set_expression(XPathFragment _expression) {
        this._expression = _expression;
    }

}