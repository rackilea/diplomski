import javax.validation.Valid;

@RequestMapping(value = "/getItem", method = RequestMethod.GET)
public ServiceRequest<List<SomeModel>> getClaimStatuses(@Valid RequestParamsModel model) {
    // ...
}