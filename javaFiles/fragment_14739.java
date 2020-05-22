@RequestMapping(value = "/brands.do", method = RequestMethod.POST)
public @ResponseBody Map<String, Object> map doActions(@ModelAttribute Brands brands, 
BindingResult result, @RequestParam String action, Map<String, Object> map) 
{
    Brands brandsResult = new Brands();
    switch (action.toLowerCase()) {
    case "add":
        brandsService.add(brands);
        brandsResult = brands;
        break;
    case "edit":
        brandsService.edit(brands);
        brandsResult = brands;
        break;
    }
    map.put("brands", brandsResult);
    map.put("brandsList", brandsService.getAllBrands());
    return map;
}