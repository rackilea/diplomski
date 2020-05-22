@ResponseBody
public Map<String, Object> getGame(@PathVariable("id") long id, String include) {

    Game game = service.loadGame(id);
    // check the `include` parameter and create a map containing only the required attributes
    Map<String, Object> gameMap = service.convertGameToMap(game, include);

    return gameMap;

}