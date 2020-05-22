@RequestMapping(value = "v1/test", method = RequestMethod.POST,consume="text/xml",produces="application/json")
@ResponseBody
public ResponseEntity<CustomObject> test(@RequestBody CustomXMLObject) {
    // do some logical things for example change to json

return new ResponseEntity<CustomObject>(convertedJsonObject,HttpStatus.OK);
}