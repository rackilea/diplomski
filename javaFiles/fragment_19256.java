#Resource
@GetMapping("/order/list")
public @ResponseBody 
ResponseEntity<?> getOrderListItemsByMerchant(
    @RequestParam Map<String, Object> params) {
    // method code
}

#Feign Client
@RequestMapping(method = RequestMethod.GET, value = "/api/order/list")
ResponseEntity<String> getOrderList(@RequestParam Map<String, Object> params);

#Microservice Controller
@GetMapping("/order/list")
public @ResponseBody
ResponseEntity getOrderListItemsByMerchant(OrderListItemParameters orderListItemParams) {
    // method code
}