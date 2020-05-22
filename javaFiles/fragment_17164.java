@PostMapping(value = "/v1/notification")
public String handleNotifications(@RequestParam(value="con", required=false) String itemid, @RequestParam(value="dp", required=false) String dp, @RequestParam(value="type", required=false) String type ) 
    {
     // you can use all these values directly in this method
    // parse here the values
return "result";
}