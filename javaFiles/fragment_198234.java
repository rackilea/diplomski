@GetMapping("/searchCommodities")
public ResponseEntity<List<CommodityDTO>> findCommodities(
         @QuerydslPredicate(root = Commodity.class) Predicate predicate,Pageable pageable){

     return new ResponseEntity<List<CommodityDTO>> 
                (commodityService.getCategories(predicate, pageable), HttpStatus.OK);
}