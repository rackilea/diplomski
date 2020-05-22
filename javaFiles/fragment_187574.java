@RequestMapping("/")
public String home() {
    return "index";
}

@RequestMapping("/test.html")
public String test() {
    return "test";
}