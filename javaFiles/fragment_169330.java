@RequestMapping(value = "/package/{id}", method = RequestMethod.PUT)
@ResponseStatus(HttpStatus.OK)
@ResponseBody
public SPackage updatePackage(@PathVariable String id, @RequestBody YourJsonPOJO   
 sPackage) {
}