@RequestMapping(value = "/foo", method = RequestMethod.POST, 
    params = {"saveRequest"})
public String saveFoo(@ModelAttribte Foo foo, BindingResult result) { ... }

// Only "id" field is bound for delete request
@RequestMapping(value = "/foo", method = RequestMethod.POST, 
    params = {"deleteRequest"})
public String deleteFoo(@RequestParam("id") long id) { ... }