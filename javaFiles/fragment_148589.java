package my.com.atomikos.jdbc;

import java.util.Enumeration;
import java.util.Properties;

public class AtomikosDataSourceBean extends com.atomikos.jdbc.AtomikosDataSourceBean {
    private static final long serialVersionUID = 1L;

    protected String printXaProperties()
    {
        Properties xaProperties = getXaProperties();
        StringBuffer ret = new StringBuffer();
        if ( xaProperties != null ) {
            Enumeration it = xaProperties.propertyNames();
            ret.append ( "[" );
            boolean first = true;
            while ( it.hasMoreElements() ) {
                String name = ( String ) it.nextElement();
                if ( name.equals ( "password" ) ) continue;
                if ( ! first ) ret.append ( "," );
                String value = xaProperties.getProperty( name );
                ret.append ( name ); ret.append ( "=" ); ret.append ( value );
                first = false;
            }
            ret.append ( "]" );
        }
        return ret.toString();
    }
}