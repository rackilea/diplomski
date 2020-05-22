import java.beans.BeanDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotations.Descriptor;
import annotations.Property;

public class ExampleBeanBeanInfo extends SimpleBeanInfo {

    private final static Class<ExampleBean> myClass = ExampleBean.class;

    public PropertyDescriptor[] getPropertyDescriptors() {

        List<PropertyDescriptor> propertyDescriptors = new ArrayList<>();

        try {

            for (Field field : myClass.getDeclaredFields()) {

                if (field.isAnnotationPresent(Property.class)) {

                    Annotation annotation = field.getAnnotation(Property.class);
                    Property property = (Property) annotation;

                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), myClass);
                    propertyDescriptor.setDisplayName(property.displayName());
                    propertyDescriptor.setShortDescription(property.shortDescription());

                    propertyDescriptors.add(propertyDescriptor);
                }

            }

            return propertyDescriptors.toArray(new PropertyDescriptor[propertyDescriptors.size()]);
        } catch (Exception iexErr) {
            throw new Error(iexErr.toString());
        }
    }

    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor desc = new BeanDescriptor(myClass);

        if (myClass.isAnnotationPresent(Descriptor.class)) {

            Annotation annotation = myClass.getAnnotation(Descriptor.class);
            Descriptor descriptor = (Descriptor) annotation;

            desc.setDisplayName(descriptor.displayName());
            desc.setShortDescription(descriptor.shortDescription());

        }

        return desc;
    }

}