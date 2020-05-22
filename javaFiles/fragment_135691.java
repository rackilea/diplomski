@Controller
public class NewPlayerController {

    @Resource(name="tennisPlayerService")
    private PlayerService<TennisPlayer> playerService;

    //omitted RequestMethod.GET handler method  

    @RequestMapping(value = "/newplayer", method = RequestMethod.POST)
    public String newplayer(Locale locale, @ModelAttribute("tennisPlayer") @Valid TennisPlayer tennisPlayer,
        BindingResult result, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            return "newplayer";
        }

        playerService.createPlayer(tennisPlayer);

        MessageUtil.flash(locale, redirectAttributes, "success", "signup.success");

        return "redirect:/allplayers";

    }
}

public interface PlayerService<T extends Player> {

    public void createPlayer(T player);

    public List<T> getAllPlayers();
}

@Service(value="tennisPlayerService")
public class TennisPlayerDbService implements PlayerService<TennisPlayer> {

    private TennisPlayerDAO dao;

    @Autowired
    public void setDao(TennisPlayerDAO dao) {
        this.dao = dao;
    }

    @Override
    public void createPlayer(TennisPlayer player) {     
        dao.saveAndFlush(player);
    }

    @Override
    public List<TennisPlayer> getAllPlayers() {
        return dao.findAll();
    }
}