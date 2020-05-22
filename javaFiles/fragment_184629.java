@RequestMapping(
    value="/users",
    method= {RequestMethod.GET, RequestMethod.POST},
    headers= {"content-type=application/json"}
    )
public ResponseEntity<List<User>> getUsers(final HttpServletRequest request) {
    if(request.getMethod().equals("GET")) {
        System.out.println("This is a GET request response.");
    } else if(request.getMethod().equals("POST")) {
        System.out.println("This is a POST request response.");
    }
}