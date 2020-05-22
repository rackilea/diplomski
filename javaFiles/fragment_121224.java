class PDActionNamed extends PDAction {

    public static final String SUB_TYPE = "Named";    

    public PDActionNamed() {
        super();
        setSubType( SUB_TYPE );
    }

    public void setN( String s ) {
        action.setName( "N", s );
    }
}