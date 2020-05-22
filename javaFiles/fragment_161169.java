@Resource(name = "serviceStrategy")
IServiceStrategy serviceStrategy;

@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "text/html")
@ResponseBody
public String search(@RequestParam(value = "partner", required = true) String partnerType, String... params) {
  ISearchService service = (ISearchService) serviceStrategy.getService(ServiceType.SEARCH, partnerType);
  return service.search(params);
}