@RestController
class IslandController {

    @GetMapping("/greeting")
    fun getMessage() = "hello world"
}