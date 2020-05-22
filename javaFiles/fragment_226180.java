package forum10174513;

import javax.xml.bind.Unmarshaller;

public class BaseBeanEx extends BaseBean {

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        System.out.println("AFTER UNMARSHAL WAS CALLED");
    }

}