@RequestMapping(value = "/api/authenticate",method = RequestMethod.POST, consumes = "application/json")
 @ResponseBody
 public User getUser(@RequestBody User user) {
 //here request body contains User POJO object's payload (JSON object)

   //You are getting username from JSON, 
   //so you need to update your call to findOne method
   return repo.findOne(user.getUserName());
}