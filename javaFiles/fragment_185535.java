@RequestMapping(value = {"/{id}", "/user/{userId}"}, method = RequestMethod.GET)
public void getUser(@PathVariable(value = "id", required = false) String id,
  @PathVariable(value = "userId", required = false) Long userId) {
    if (id != null) {
    //TODO stuff for id
   }
   if (userId != null) {
    //TODO stuff for userId
   }