public class Application {

    @OneToMany(mappedBy="application", orphanRemoval = true, fetch = FetchType.EAGER)
    @Cascade([SAVE_UPDATE, DELETE, MERGE])
    @Fetch(FetchMode.SELECT)

    // Normally we'd just use the @Where(clause = "PROJ_VSN_EFF_TO_DTM is null"), but that doesn't work with collections of
    // entities that use inheritance, as we have here.
    //
    // Hibernate thinks that PROJ_VSN_EFF_TO_DTM is a column on DFIP_APPLN_PROJ_VERSION table, but it is actually on the "superclass"
    // table (DFIP_PROJECT_VERSION). 
    //
    // B/c of this, we have to do the same thing with a Filter, which is defined on AbstractProjectVersion.
    // NOTE: This filter must be explicitly enabled, which is currently achieved by HibernateForceFiltersAspect 
    //
    @Filter(name="currentProjectVersionOnly", 
        condition = "{pvAlias}.PROJ_VSN_EFF_TO_DTM is null", 
        deduceAliasInjectionPoints=false, 
        aliases=[ @SqlFragmentAlias(alias = "pvAlias", table = "DFIP_PROJECT_VERSION") ]
    )
    List<ApplicationProjectVersion> projectVersions = [];

}