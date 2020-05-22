public aspect SkipEncoding {  
    pointcut encodingInExtFilter() : 
        cflow( * org.apache.myfaces.webapp.filter. ExtensionsFilter.doFilter(..) ) && 
        call ( String UnicodeEncoder.encode( String, bool, bool ));   
    around( String s, bool b1, bool b2 ) : encodingInExtFilter
    {
        return s; // skip encoding
    }
}