public class MyCustomMessageCodesResolver implements MessageCodesResolver {

    private DefaultMessageCodesResolver defaultMessageCodesResolver = new DefaultMessageCodesResolver();

    public String [] resolveMessageCodes(String errorCode, String objectName) {
        if(errorCode.equals("age"))
            /**
              * Set up your custom message right here
              */
            return new String[] {"typeMismatch.age"};

        return defaultMessageCodesResolver.resolveMessageCodes(String errorCode, String objectName);
    }

    public void String[] resolveMessageCodes(String errorCode, String objectName, String field, Class fieldType) {
        if(errorCode.equals("age"))
            /**
              * Set up your custom message right here
              */
            return new String[] {"typeMismatch.age"};

        return defaultMessageCodesResolver.resolveMessageCodes(String errorCode, String objectName, String field, Class fieldType);
    }
}