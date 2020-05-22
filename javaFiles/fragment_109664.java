public class FixedDefaultComponentSafeNamingStrategy extends DefaultComponentSafeNamingStrategy {
    @Override
    public String propertyToColumnName(String propertyName) {
        return super.propertyToColumnName(
            propertyName.replace(".collection&&element.", "."));
    }
}