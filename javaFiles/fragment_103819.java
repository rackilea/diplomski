@GetMapping("/hello/{name}")
@ResponseBody
public String sayHello(@PathVariable("name") String name)
{
    return "Hello " + name;
}