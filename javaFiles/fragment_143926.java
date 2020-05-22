@RequestMapping(method=RequestMethod.GET, value={"/campaigns","/campaigns/{id}"})
public String getCampaignDetails(Model model,
     @RequestParam(value="id", required=false) Long id,
     @PathVariable("id") Long id2)
{
}