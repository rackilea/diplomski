@RequestMapping(value={"/notification/save/{id}"},  method = {RequestMethod.GET, RequestMethod.POST},
         produces = "application/json"

        )
public @ResponseBody String update(@PathVariable("id") long id, AccountNotification accountNotification){
    String result="ok";