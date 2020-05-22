//imports

@Path("/visitor")
@Produces({MediaType.APPLICATION_JSON, ExtraMediaTypes.PROTOBUF})
@Consumes(MediaType.APPLICATION_JSON)
public class VisitorResource {
  //other variables
  private final VisitorParams visitorParams;

  @Inject
  public VisitorResource(/*other variables*/) {
    this.contactsManager = contactsManager;
    this.activityFetcherProvider = activityFetcherProvider;
    this.visitSourceMapper = visitSourceMapper;
    this.timeZoneClient = timeZoneClient;
    this.gatesClient = gatesClient;
    this.smallScanLimit = smallScanLimit;
    this.portalIdProvider = portalIdProvider;
    //removed visitorParams here
  }

  @Timed
  @GET
  @Path("/{identity}/activities")
  //moved it to the methods
  public List<Activity> getActivitiesGet(@PathParam("identity") String identity, @Bind({Bind.Params.QUERY}) VisitorParams visitorParams) throws Exception {
    this.visitorParams = visitorParams;
    return getActivities(identity);
  }

  //other methods
}