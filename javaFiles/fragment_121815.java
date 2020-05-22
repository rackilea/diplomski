// NOTE: This filter needs to be explicitly turned on with session.enableFilter("currentProjectVersionOnly");
// This is currently achieved with HibernateForceFiltersAspect
@FilterDef(name="currentProjectVersionOnly")

@Table(name = "DFIP_PROJECT_VERSION")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractProjectVersion  {

}