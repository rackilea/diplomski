public static enum DataValueModifier {

    ...

    public boolean isModifier( String modifierString ) 
    {
       return modifierString != null && value.equals(modifierString);
    }
}