@RequestMapping(value = "/op")
public void methodWithRequestParams(@RequestParam(value = "param1", required = false) String param1, 
        @RequestParam(value = "param2", required = false) String param2) {
  if (param1 == null || param2 == null) {
    throw new ResourceNotFoundException();
  }
}