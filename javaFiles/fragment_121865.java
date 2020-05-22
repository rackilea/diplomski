class OrgWorkService {

  @Autowired OrgWorkRepository orgWorkRepository;

  List<OrgWork> findOrgWorks(OrgWork probe) {
    return orgWorkRepository.findAll(Example.of(probe));
  }
}