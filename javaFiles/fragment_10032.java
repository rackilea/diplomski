import java.util.Optional;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;



@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "RootType", propOrder = {
    "seq1",
    "p",
    "q"
})
@XmlRootElement(name="TopLevel")
public class RootType {


    @XmlPath(".")
    private InnerSequence seq1;
    @XmlElement(name = "P")
    private P p;
    @XmlElement(name = "Q")
    private Q q;

    public static class InnerSequence 
    {
        @XmlElement(name = "A")
        public A a;
        @XmlElement(name = "B")
        public B b;
        @XmlElement(name = "C")
        public C c;

        public boolean isEmpty() {
            return c==null&&b==null&&a==null;
        }
        ...
    }
...