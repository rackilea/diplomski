@RestController // @ResponseBody not needed when using like this
public MyDataController {

    @Autowired
    private MyDataService myDataService;

    @RequestMapping("/getMyData") // no need to specify method for GET
    public MyDataResponse getMyData(@RequestParam("ID") Long myDataId) {

            ... validation logic

            return myDataService.getMyData(myDataId); // return response
    }
}