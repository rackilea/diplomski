import com.fasterxml.jackson.annotation.JsonIgnore;

public class IpadField {

    @JsonIgnore
    public String fieldname;
    public String Text_de;
    public String Text_en;
    public String Preis;
    public String Materialnummer;

    public IpadField() {

    }

    @Override
    public String toString() {
        return "IpadField{" + "fieldname='" + fieldname + '\'' + ", Text_de='" + Text_de + '\'' + ", Text_en='"
                + Text_en + '\'' + ", Preis='" + Preis + '\'' + ", Materialnummer='" + Materialnummer + '\'' + '}';
    }

    public IpadField(String fieldname, String text_de, String text_en, String preis, String materialnummer) {
        this.fieldname = fieldname;
        Text_de = text_de;
        Text_en = text_en;
        Preis = preis;
        Materialnummer = materialnummer;
    }

}