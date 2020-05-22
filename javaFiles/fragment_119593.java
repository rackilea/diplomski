package model;

import static javax.xml.bind.annotation.XmlAccessType.NONE;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(NONE)
public class Tuple2 {
    private Coords c1;
    private Coords c2;

    public Tuple2(Coords c1, Coords c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Tuple2() {
        c1 = new Coords(0, 0);
        c2 = new Coords(0, 0);
    }

    @XmlElement
    public Coords getFirst() {
        return this.c1;
    }

    @XmlElement
    public Coords getSecond() {
        return this.c2;
    }
}