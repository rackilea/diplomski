package forum14945664;

import java.util.*;

import org.eclipse.persistence.jaxb.metadata.MetadataSourceAdapter;
import org.eclipse.persistence.jaxb.xmlmodel.*;
import org.eclipse.persistence.jaxb.xmlmodel.JavaType.*;
import org.eclipse.persistence.jaxb.xmlmodel.XmlBindings.*;

public class ExampleMetadataSource extends MetadataSourceAdapter {

    private ObjectFactory objectFactory;
    private Map<Class<?>, JavaType> javaTypes;
    private XmlBindings xmlBindings;

    public ExampleMetadataSource() {
        objectFactory = new ObjectFactory();
        javaTypes = new HashMap<Class<?>, JavaType>();

        xmlBindings = new XmlBindings();
        xmlBindings.setPackageName("forum14945664");
        xmlBindings.setJavaTypes(new JavaTypes());
    }

    @Override
    public XmlBindings getXmlBindings(Map<String, ?> properties, ClassLoader classLoader) {
        return xmlBindings;
    }

    public JavaType getJavaType(Class<?> clazz) {
        JavaType javaType = javaTypes.get(clazz);
        if(null == javaType) {
            javaType = new JavaType();
            javaType.setName(clazz.getSimpleName());
            javaType.setJavaAttributes(new JavaAttributes());
            xmlBindings.getJavaTypes().getJavaType().add(javaType);
            javaTypes.put(clazz, javaType);
        }
        return javaType;
    }

    public void setXmlTransient(Class<?> domainClass, String propertyName) {
        XmlTransient xmlTransient = new XmlTransient();
        xmlTransient.setJavaAttribute(propertyName);
        JavaType javaType = getJavaType(domainClass);
        javaType.getJavaAttributes().getJavaAttribute().add(objectFactory.createXmlTransient(xmlTransient));
    }

}