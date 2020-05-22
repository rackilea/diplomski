@RequestMapping(value = Uris.MAIN)
    public String home(Model model) {
    List <SPInfo> SPStatusList = new ArrayList<SPInfo>();
    for (ServiceProviders sp : ServiceProviders.values()) {
        SPConnectionRetriever spAccess = SPBank.getSPConnection(sp);
        SPStatusList.add(new SPInfo(sp.toString(), spAccess.isconnected(), spAccess.getPermissions(),spAccess.getConnectUrl()));
    }

    model.addAttribute("nom", SecurityContext.getCurrentUser().getId());
       model.addAttribute("serviceProviders", SPStatusList);

    return Uris.WORK;
}