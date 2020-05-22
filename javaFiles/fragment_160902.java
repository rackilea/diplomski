public static DataValueModifier toDataValueModifier( String dataValue ) {
    if( EQUAL.isModifier( dataValue ) {
       return EQUAL;
    } else if( GREATER_THAN.isModifier( dataValue ) {
       return GREATER_THAN;
    } else if...
       // Do this for all possible values
    } else {
       return UNKNOWN;
       // Also, add an UNKNOWN to your list of enum values.
    }
}