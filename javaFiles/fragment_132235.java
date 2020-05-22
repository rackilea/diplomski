@SessionAttributes("tweets")
public class TweetsController {

    private TweetsService tweetsService;

    @ModelAttribute("tweets")
    // name for tweet form in home public Tweets
    public Tweets construct() {
        return new Tweets();
    }

    // //----------------------------------------------------------------------
    @RequestMapping(value = "/")
    public String newTweet(Model model) {
        model.addAttribute("tweets", new CreateTweet());
        return "/home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String tweet(@ModelAttribute("tweets") CreateTweet tweet, BindingResult result,
                        RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "redirect:/";
        }
        tweetsService.createTweet(tweet);
        return "redirect:/";
    }

}