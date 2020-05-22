@Path("/calendar")
public class CalendarResource {

 @Inject("memberService")
 private MemberService memberService;

 @Inject
 private ObjectMapper mapper;

 @GET
 @Produces(MediaType.APPLICATION_JSON)
 public String getCalendars() {
  Member member = memberService.getCurrentMember();
  try {
   return mapper.writeValueAsString(member.getCalendarFeeds());
  } catch (JsonGenerationException e) {
  } catch (JsonMappingException e) {
  } catch (IOException e) {
  }
  return "{}";
 }
}