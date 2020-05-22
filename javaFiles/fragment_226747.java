public class CaseInsensitiveAliasToBeanResultTransformer {
    private void initialize(String[] aliases) {
        this.aliases = new String[ aliases.length ];
        setters = new Setter[aliases.length];
        for ( int i = 0; i < aliases.length; i++ ) {
            String alias = aliases[i];
            if (alias != null) {
                this.aliases[i] = alias;
                setters[i] = CaseInsensitiveSetter.getSetter(resultClass, alias);
            }
        }
        isInitialized = true;
    }
}