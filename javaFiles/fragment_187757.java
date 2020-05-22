@RequestMapping(value="/rest/greetMe", method= RequestMethod.GET)
public @ResponseBody Greeting sayHello(
        @RequestParam(value = "name", required = false, defaultValue = "Stranger") String name,
        @RequestParam(value = "language", required = false, defaultValue = "en") String language) {
    return new Greeting(counter.incrementAndGet(), String.format(getTemplate(language), name));
}

@RequestMapping(value="/rest/greetMe", method= RequestMethod.POST)
public @ResponseBody Greeting sayHello(
        @RequestBody(required = true) Input input) {
    return new Greeting(counter.incrementAndGet(),
            String.format(getTemplate(input.getLanguage()), input.getName()));
}