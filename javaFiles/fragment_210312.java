@RequestMapping(value="/rest/sites", method=RequestMethod.GET)
public String getSites(@RequestParam Integer companyId, Model model) {
    Collection<Site> sites = cms.getSites(cms.getCompany(companyId));
    SitesResult sitesResult = new SitesResult(sites);
    model.addAttribute("sitesResult", sitesResult);
    String myView = "myView";
    return myView;
}