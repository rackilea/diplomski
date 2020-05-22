import org.apache.commons.codec.binary.StringUtils;
import com.thoughtworks.xstream.XStream;

public static byte[] serializeToXML(Object obj, XStream xStreamConfig)
    throws Exception
{
    XStream xstream;
    String certObjString;
    byte[] certObjByte;

    if(xStreamConfig == null) {
        xstream = new XStream();
    } else {
        xstream = xStreamConfig;
    }

    certObjString = xstream.toXML(obj);

    certObjByte = StringUtils.getBytesUtf8(certObjString);

    return certObjByte;
}

public static Object deserializeFromXML(byte[] objectByteArray, XStream xStreamConfig)
{
    String objectString;
    Object object;
    XStream xstream;

    if(xStreamConfig == null) {
        xstream = new XStream();
    } else {
        xstream = xStreamConfig;
    }

    objectString = StringUtils.newStringUtf8(objectByteArray);

    object = xstream.fromXML(objectString);

    return object;
}