@RequestMapping(value = "/SubmitStep1.json", method = RequestMethod.POST,  headers = "Accept=application/json,application/xml")
@ResponseBody
public ResponseEntity<ShopListResponse> showShopList(@RequestBody ShopDetails shopDetails)throws Exception{

List<ShopDetails> shopDetailsList = dbq.getShopDetails(shopDetails);
return new ResponseEntity<>(new ShopListResponse(shopDetailsList, "Success or error message"), HttpStatus.OK); 
}