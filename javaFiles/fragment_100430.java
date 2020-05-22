package org.example.schema;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sampleTest", propOrder = {"actualData"})
public class SampleTest {

    @XmlElement(required = true)
    protected List<ActualData> actualData;

    public List<ActualData> getActualData() {
        if (actualData == null) {
            actualData = new ArrayList<ActualData>();
        }
        return this.actualData;
    }

}