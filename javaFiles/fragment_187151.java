@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type = LocalDateTime.class, 
                        value = LocalDateTimeAdapter.class)
})
package thepackage.of.the.models;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;