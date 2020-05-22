@RequestMapping(value="/json/world/get/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<World> getWorlds() {
    return worldManager.findAll();
}


@RequestMapping(value="/json/world/get/all2", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<World> getWorldsWithOutHellos() {
    List<World> result = worldManager.findAll();
    for (World world:result){
       world.setHello(null);
    }
    return result;
}