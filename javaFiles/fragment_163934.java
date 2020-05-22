public class MyException extends RuntimeException
 {
    private static final long serialVersionUID = 5224152764776895846L;

    private static final ResourceBundle MESSAGES;
    static
    {
        MESSAGES = ResourceBundle.getBundle("....MyExceptionMessages");
    }

    public static final String NO_CODE = "unknown";
    public static final String PROBLEMCODEONE = "problemCodeOne";
    public static final String PROBLEMCODETWO = "problemCodeTwo";
    // ... some more self-descriptive problem code constants

    private String errorCode = NO_CODE;
    private Object[] parameters = null;

    // Define some constructors

    public MyException(String errorCode)
    {
        super();
        this.errorCode = errorCode;
    }

    public MyException(String errorCode, Object[] parameters)   
    {
        this.errorCode = errorCode;
        this.parameters = parameters;
    }

    public MyException(String errorCode, Throwable cause)
    {
        super(cause);
        this.errorCode = errorCode;
    }

    public MyException(String errorCode, Object[] parameters, Throwable cause)
    {
        super(cause);
        this.errorCode = errorCode;
        this.parameters = parameters;
    }   

    @Override
    public String getLocalizedMessage()
    {
        if (NO_CODE.equals(errorCode))
        {
            return super.getLocalizedMessage();
        }

        String msg = MESSAGES.getString(errorCode); 
        if(parameters == null)
        {
            return msg;
        }
        return MessageFormat.format(msg, parameters);
    }
 }