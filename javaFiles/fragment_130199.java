import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(ExampleBean.class);

        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();

        System.out.printf( "Bean display name = '%s', description = '%s'\n", beanDescriptor.getDisplayName(), beanDescriptor.getShortDescription());

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

            String propertyName = propertyDescriptor.getName();

            System.out.printf("Property field name = '%s', display name = '%s', description = '%s'\n", propertyName, propertyDescriptor.getDisplayName(), propertyDescriptor.getShortDescription());

        }

        System.exit(0);
        ;
    }
}