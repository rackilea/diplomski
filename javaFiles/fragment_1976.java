@RequestMapping(value="/narrow/headers/{name}/{email}/{customerNumber}",
        method={RequestMethod.POST,RequestMethod.GET},
        headers="Referer=http://localhost:8080/SpringMVC/request-mappings.html")
public ResponseEntity<String> narrowOnHeaders(
        @PathVariable("name")String name, 
        @PathVariable("email") String email, 
        @PathVariable("customerNumber") Integer customerNumber,
        @RequestHeader("Referer") String referer
    )