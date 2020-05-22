@RequestMapping(value="user", method = RequestMethod.GET)
public @ResponseBody Item getItem(@RequestParam("data") String itemid){

    Item i = itemDao.findOne(itemid);              
    String itemName = i.getItemName();
    String price = i.getPrice();
    return i;
}