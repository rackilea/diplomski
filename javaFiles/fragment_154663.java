package forum10028037;

import javax.xml.bind.annotation.XmlElement;

class Circle{

    private float radius;
    private float pi;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getPi() {
        return pi;
    }

    public void setPi(float pi) {
        this.pi = pi;
    }

    @XmlElement
    public float getArea(){
        return pi * radius * radius;
    }

}