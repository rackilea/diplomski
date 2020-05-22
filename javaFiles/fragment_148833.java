@Value.Immutable
public abstract class AdditionalInfo  {
    abstract @Nullable String getCountry();

    public String getCountryCanonical() {
      return getCountry != null ? getCountry : DEFAULT_VALUE;
}
}