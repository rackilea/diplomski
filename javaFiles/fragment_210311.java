@RequestMapping(value="/rest/sites", method=RequestMethod.GET)
public SitesResult getSites(@RequestParam Integer companyId) {
    Collection<Site> sites = cms.getSites(cms.getCompany(companyId));
    SitesResult sitesResult = new SitesResult(sites);
    return sitesResult;
}