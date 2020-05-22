package xml.utils;

public class XmlException extends Exception {
    private static final long serialVersionUID = 1L;

    public XmlException(String message, Throwable cause)  {
        super(message, cause);
    }

    public XmlException(String message)  {
        super(message);
    }

    public XmlException(Throwable cause)  {
        super(cause);
    }
}