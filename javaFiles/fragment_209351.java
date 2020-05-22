import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jc =  JAXBContext.newInstance(ModelWrapper.class);

        ModelWrapper mw = new ModelWrapper();

        List<Model> list = new ArrayList<Model>();
        Model m = new Model();
        m.setId(1);
        m.setName("model1");
        list.add(m);
        m = new Model();
        m.setId(1);
        m.setName("model2");
        list.add(m);

        mw.setList(list);

        Marshaller mar = jc.createMarshaller();

        mar.marshal(mw, System.out);


    }

}