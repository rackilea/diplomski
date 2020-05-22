import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class UserConverter implements Converter
{

    @Override
    public boolean canConvert(Class clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer,
            MarshallingContext context) 
    {

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) 
    {
        User user = new User();

        reader.moveDown();
        if ("fullName".equals(reader.getNodeName()))
        {
            String[] name = reader.getValue().split("\\s");
            user.setFirstName(name[0]);
            user.setLastName(name[1]);
        }
        reader.moveUp();

        return user;
    }
}