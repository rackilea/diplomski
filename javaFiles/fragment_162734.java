public class UserAttribute {
  private final String attributeKey;
  private final int schemaId;               // unsigned short
  private final long lastModifiedDate;
  private final byte[] avroBinaryData;      // preceded by length: unsigned short
  // constructor and getters here

}

int numberOfAttributes = dis.readShort();
List<UserAttribute> ual = new ArrayList<>( numberOfAttributes );
for( int iAttr = 0; iAttr < numberOfAttributes; ++iAttr ){
    // read values for one attribute, create UserAttribute  object
    UserAttribute ua = new UserAttribute();
    StringBuilder sb = new StringBuilder();
    for(;;){
        int ub = dis.readUnsignedByte(); // can this be in ISO-8859-1 > 0x80?
        if( ub == 0 ) break;
        sb.append( (char)ub );
    }
    ua.setAttributeKey( sb.toString() );
    ua.setSchemaId( dis.readUnsignedShort() );
    ua.setLastModifiedDate( dis.readLong() );
    int loabd = dis.readUnsignedShort();
    byte[] abd = new byte[loabd];
    for( int ib = 0; ib < loabd; ++ib ){
        abd[ib] = dis.readByte();
    }
    ua.setAvroBinaryData();
    ual.add( ua );
}