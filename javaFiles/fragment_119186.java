@RestController
@RequestMapping("/stat/player")
public class PlayerController {

    @Autowired
    private StatService<PlayerValue> statPlayer;

    @RequestMapping("/number/{number}")
    public StateResponseValue<T> findByNumber(@PathVariable String number) { // Here returning Object seem odd
        return statPlayer.findByNumber(number);
    }
}