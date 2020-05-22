package test;

import java.io.File;
import java.util.Collection;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAttribute;

public class Element
{
    private String exp;
    private boolean display;
    private String id;
    private Collection<Element> element;

    @XmlAttribute
    public String getExp()
    {
        return exp;
    }
    public void setExp(String exp)
    {
        this.exp = exp;
    }

    @XmlAttribute
    public boolean isDisplay()
    {
        return display;
    }
    public void setDisplay(boolean display)
    {
        this.display = display;
    }

    @XmlAttribute
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public Collection<Element> getElement()
    {
        return element;
    }
    public void setElement(Collection<Element> element)
    {
        this.element = element;
    }

    public static void main(String[] args)
    {
        Element e = JAXB.unmarshal(new File("C:/testFile.xml"), Element.class);
        System.out.println(e.getElement().size());
    }
}