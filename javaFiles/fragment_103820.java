@GetMapping("/hello/{name}")
public String sayHello(@PathVariable("name") String name, HttpServletRequest request)
{
    System.out.println("-----------------------------------------");
    System.out.println("Request URL: "+request.getRequestURL());
    System.out.println("name: "+name);
    return "Hello " + name;
}