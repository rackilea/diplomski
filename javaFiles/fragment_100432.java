package org.example.schema;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sampleTest", propOrder = {"actualDatas"})
public class SampleTest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "actualData", required = true)
    protected List<ActualData> actualDatas;

    public List<ActualData> getActualDatas() {
        if (actualDatas == null) {
            actualDatas = new ArrayList<ActualData>();
        }
        return this.actualDatas;
    }

}