public class Feed extends JsonModel {
  private static final long serialVersionUID = -8152796378433288199L;

  @SerializedName("feed_id")
  private int feedId;

  @SerializedName("title")
  private String title;

  @SerializedName("logo_url")
  private String logoUrl;

  @SerializedName("site_url")
  private String siteUrl;

  public int getFeedId() {
    return feedId;
  }

  public void setFeedId(int feedId) {
      this.feedId = feedId;
  }

  public String getTitle() {
     return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getSiteUrl() {
    return siteUrl;
  }

  public void setSiteUrl(String siteUrl) {
    this.siteUrl = siteUrl;
  }