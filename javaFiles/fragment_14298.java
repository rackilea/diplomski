@RequestMapping(value = "/greeting")
public String sayHello(Model model){

    model.addAttribute("greeting", "Hello World");

    return "hello";
}