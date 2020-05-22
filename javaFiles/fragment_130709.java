@AutoValue
public abstract class Office {
  private String regionName;

  public abstract String getCompanyName();
  public abstract String getCityName();
  public String getRegionName() {
    return regionName;
  }

  public static Office create(String cityName, String companyName, String regionName) {
    Office office = new AutoValue_Office(cityName, companyName);
    office.regionName = regionName;
    return office;
  }
}