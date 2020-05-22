package forum11667335;

import javax.xml.bind.annotation.XmlSchemaType;

public class SpThread {

    private int durTime;

    @XmlSchemaType(name="nonNegativeInteger")
    public int getDurTime() {
        return durTime;
    }

    public void setDurTime(int durTime) {
        this.durTime = durTime;
    }

}