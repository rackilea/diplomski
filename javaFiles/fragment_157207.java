package example;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import example.adapted.AdaptedWrapper;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(AdaptedWrapper.class);

        File xml = new File("input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        AdaptedWrapper adaptedWrapper = (AdaptedWrapper) unmarshaller.unmarshal(xml);
        Wrapper wrapper = adaptedWrapper.getWrapper();

        for(Channel channel : wrapper.getChannels()) {
            System.out.println(channel.getName());
        }
    }

}