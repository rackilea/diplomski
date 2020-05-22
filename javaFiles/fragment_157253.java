@RequestMapping(value = "/add/{name}", method = RequestMethod.POST)
public String processForm(@PathVariable String name, WebRequest request) {
    //System.out.println(bean);

    Object myBean = registry.lookup(name);
    WebRequestDataBinder binder = new WebRequestDataBinder(myBean);
    // optionnaly configure the binder
    ...
    // trigger actual binding of request parameters
    binder.bind(request);
    // optionally validate
    binder.validate();
    // process binding results
    BindingResult result = binder.getBindingResult();
    ...

    return "redirect:/add/" + name;
}