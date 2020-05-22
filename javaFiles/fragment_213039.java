package example;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Root {

    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double maxDouble = Double.MAX_VALUE;

    @XmlJavaTypeAdapter(DoubleAdapter.class)
    public Double aDouble = 123d;

}