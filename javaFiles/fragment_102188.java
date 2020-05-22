public class YourController {

  @Autowired private SpeakerTopicsRepository speakerTopicsRepository;

  @RequestMapping(value = "/lectures/{lectureId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Map<String, SpeakerTopicLectures> getLecture(@PathVariable Long lectureId) {
     // your method...
  }

}