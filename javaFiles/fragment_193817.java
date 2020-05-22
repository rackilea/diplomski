@Override
public boolean handleEvent ( Event evt ) {
    if ( evt.target instanceof Button ) { //this line hasn't a problem
        if ( evt.arg.equals ( "CLOSE" ) ) {
            System.exit ( 0 ); //calls a function 
            return true;
        }
    }
    return super.handleEvent ( evt );
}