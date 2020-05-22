public static void itemDetails(Long id, String keyword) {
    //selected item     
    Item item = Item.findById(id);
    List<item> items;
    if (StringUtils.isNotBlank(keyword) ) {
      String query="select distinct item from Item item where item.name like :pattern";
      items = Item.find(query).bind("pattern", pattern).fetch();
    } else {
      items = Item.find("order by creationDate desc").fetch();
    }
    render(items,item);
}