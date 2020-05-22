import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

    public class Parser {


    public static void main(String[] args) throws Exception {
        new Parser().save();
        new Parser().load();
    }

    public void save() throws Exception {

        try {
            File file = new File("C://order.xml");
            Items item = new Items();
            item.setPcPart(new ArrayList<String>(){{add("a");add("b");add("b");}});
            JAXBContext c = JAXBContext.newInstance(Items.class);
            Marshaller m = c.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(item, file);
            m.marshal(item, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void load() throws Exception {
        try {
            File file = new File("C://order.xml");
            JAXBContext c = JAXBContext.newInstance(Items.class);
            Unmarshaller u = c.createUnmarshaller();
            Items item = (Items) u.unmarshal(file);
            u.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement

public class Items {
    private List<String> pcPart;

    @XmlElement(name = "pcPart")
    public List<String> getpcPart(){
        if(pcPart == null){
        pcPart = new ArrayList<String>();
        }
        return pcPart;
    }

    public void setPcPart(List<String> pcPart) {
        this.pcPart = pcPart;
    }



}

Output
--------------
<items>
    <pcPart>a</pcPart>
    <pcPart>b</pcPart>
    <pcPart>b</pcPart>
</items>