@RequestMapping(value = "/getUser", method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public ResponseEntity<String> getUser(@RequestParam(value = "userId", required = true) String userId)
    {

        User user = userService.findByUserId(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>(new JSONSerializer().transform(new DateTransformer("MM/dd/yyyy HH:mm:ss"), java.util.Date.class).include("field1").exclude("field2").serialize(user), headers,HttpStatus.OK);
    }