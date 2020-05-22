@Override
public boolean isOperationAllowed( Operation operation, ApiDescription api, Map< String , List< String >> params, Map< String , String > cookies, Map< String , List< String >> headers ) {

    scala.collection.immutable.List< Parameter > paramList = operation.parameters();

    for ( int i = 0; i < paramList.length(); i++ ) {

        Parameter myparam = paramList.apply( i );

        if ( myparam.paramAccess().isDefined() && myparam.paramAccess().get().equals( "private" ) ) {
            return false;
        }
        else {
            return true;
        }
    }
}