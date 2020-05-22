private String getString( String bundle, String key, String defaultValue, Object... arguments ){
    String result = ResourceBundle.getBundle( bundle ).getString( key );
    if ( result == null ){
        result = defaultValue;
    }
    if ( arguments.length > 0 && result != null ){
        result = MessageFormat.format( result, arguments );
    }
    return result; 
}