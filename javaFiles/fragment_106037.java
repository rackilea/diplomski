package a.b.c.Abc;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Abc")
public class Abc{
private String def;
private String ghi;

public Abc() {
}

public String getDef() {
    return def;
}
public void setDef(String def) {
    this.def = def;
}
public String getGhi() {
    return ghi;
}
public void setGhi(String ghi) {
    this.ghi = ghi;
}

}