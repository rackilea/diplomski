@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String index(@RequestParam("name") String name,
                            @RequestParam("file") MultipartFile file,
                            @RequestParam("desc") String desc,) {
           return "{\"name\": \"" + name + "\"}";
    }