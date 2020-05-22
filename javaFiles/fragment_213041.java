@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type=Double.class, value=DoubleAdapter.class)
})
package example;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;