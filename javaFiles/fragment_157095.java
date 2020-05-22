import org.apache.xmlrpc.common.TypeFactoryImpl;<br>
import org.apache.xmlrpc.common.XmlRpcController;<br>
import org.apache.xmlrpc.common.XmlRpcStreamConfig;<br>
import org.apache.xmlrpc.serializer.TypeSerializer;<br>
import org.xml.sax.SAXException;<br>

public class MyTypeFactory extends TypeFactoryImpl {
    public MyTypeFactory(XmlRpcController pController) {
        super(pController);
    }

    public TypeSerializer getSerializer(XmlRpcStreamConfig pConfig, Object pObject) throws SAXException  {  
        if (pObject instanceof String){
            return new MyStringSerializer();
        }else{
            return super.getSerializer(pConfig, pObject);
        }
    }
}