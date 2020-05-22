@Service
public class StreamService {

    private final Logger log = LoggerFactory.getLogger(StreamService.class);

    @Autowired
    private Twitter twitter;

    public Model streamApi(Model model, int time) throws InterruptedException{

        List<Tweet> tweets = new ArrayList<>();

        List<StreamListener> listeners = new ArrayList<StreamListener>();
        StreamListener streamListener = new StreamListener() {

            @Override
            public void onWarning(StreamWarningEvent warningEvent) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTweet(Tweet tweet) {
                System.out.println(tweet.getUser().getName() + " : " + tweet.getText());
                log.info("User '{}', Tweeted : {}", tweet.getUser().getName() , tweet.getText());
                tweets.add(tweet);
                model.addAttribute("tweets", tweets);
            }

            @Override
            public void onLimit(int numberOfLimitedTweets) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDelete(StreamDeleteEvent deleteEvent) {
                // TODO Auto-generated method stub

            }
        };

        listeners.add(streamListener);
        //This sets the GeoCode (-122.75,36.8,-121.75,37.8) of San Francisco(South-West and North-East) region as given in below twitter docs
        //https://dev.twitter.com/streaming/overview/request-parameters#locations
        Float west=-122.75f;
        Float south=36.8f;
        Float east=-121.75f;
        Float north = 37.8f;

        FilterStreamParameters filterStreamParameters = new FilterStreamParameters();
        filterStreamParameters.addLocation(west, south, east, north);

        Stream userStream = twitter.streamingOperations().filter(filterStreamParameters, listeners);
        Thread.sleep(time);
        userStream.close();
        return model;
    }
}