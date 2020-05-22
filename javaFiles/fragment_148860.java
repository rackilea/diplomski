@Override
public void writeEntityRef ( String eref ) throws XMLStreamException
{
    if ( eref == null || !eref.startsWith ( "#x" ) ) {
        super.writeEntityRef ( eref );
        return;
    }
    String hex = eref.substring ( 2 );
    for ( char c: new char[] { '\r', '\n' } )
        if ( Integer.toHexString ( c ).equals ( hex ) ) {
            this.writeCharacters ( Character.toString ( c ) );
            return;
    }
    super.writeEntityRef ( eref );
}