@RequestMapping(value = "/regions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Object regions(ServletRequest servletRequest, ServletResponse response) throws MalformedURLException, IOException{
    String filePath = "c:\\prace\\eclipse workspace\\czechtraditions\\server\\src\\main\\resources\\server-general.properties";
    return Files.readAllBytes(Paths.get(filePath));     
}