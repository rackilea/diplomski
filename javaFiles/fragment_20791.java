import org.springframework.web.client.RestTemplate;

public class GetSurvey {

   @Autowired
   private RestTemplate restTemplate;

    private static String getTemplate(String apiUrl) {
        return restTemplate.getForObject(apiUrl,String.class);
    }

    public static void main(String[] args)
    {
        int SurveyID   = 2107240;
        String SurveyDate = "2016-01-07";
        String SurveyType;
        String apiurl = "https://restapi.surveygizmo.com/v4/survey/" + SurveyID + "...";
        String result = getTemplate(apiurl);
    }
}