package forum11451880;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LifeSpan {

    protected String begin;

    protected String end;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ended;

}