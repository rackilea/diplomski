@RequestMapping(value = "/deleteGame" , method = RequestMethod.DELETE)
@ResponseBody
public void deleteGameById(@RequestBody Map<String, String> id) {
  //your logic maybe different  
  gamesService.remove(id.get("id")); 
}