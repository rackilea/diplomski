@Validated
@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @PostMapping(path = "/bets", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> bet(@RequestBody @Valid LotteryBet lotteryBet) {
        ...
    }
}