public class BindableCourse {

private Long id;
private String name;
private String shortDescription;
private String longDescription;
private String certificateText;
private String duration;
// A multivalued property. The user can select multiple regions with multiple checkboxes
// But you can also use multiple fields with the same name like address[0], address[1], etc
private List<Long> regions = new ArrayList<Long>();
private long category;
private List<String> tags = new ArrayList<String>();
private String formattedPrice;
private boolean certificate;
private String certificateName;
private List<Long> times = new ArrayList<Long>();
private List<String> dates = new ArrayList<String>();
private List<Long> options = new ArrayList<Long>();
private Calendar firstPublished;
private boolean published;
private boolean publishable;
private String linkToSite;

// getters and setters ommitted


}