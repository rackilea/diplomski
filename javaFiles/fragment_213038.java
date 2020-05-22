package example;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleAdapter extends XmlAdapter<Double, Double>{

    @Override
    public Double unmarshal(Double v) throws Exception {
        return v;
    }

    @Override
    public Double marshal(Double v) throws Exception {
       if(Double.MAX_VALUE == v) {
           return null;
       } else {
           return v;
       }
    }

}