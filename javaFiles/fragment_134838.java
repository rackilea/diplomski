package forum13159089;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Transition {

    Arc[] a;

    public Arc[] getA() {
        return a;
    }

    public void setA(Arc[] a) {
        this.a = a;
    }

}