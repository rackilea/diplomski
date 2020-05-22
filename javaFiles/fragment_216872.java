// Controller to get a JSON
@ResponseBody
@RequestMapping(value = "/stuff/{stuffId}", method = GET, produces = "application/json")
public stuffDto getStuff( ... ) { ... }

// Controller to get an HTML Form
@RequestMapping(value = "/stuff/{stuffId}", method = GET, produces = "text/html")
public String getStuffForm( ... ) { ... }