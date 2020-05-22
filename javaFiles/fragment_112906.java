@RestController
class AbcController{

    PostMapping("/api")
    public String create(@RequestBody TestPojo test){
    // you can acess your json in test object
    return "done"
    } 
}