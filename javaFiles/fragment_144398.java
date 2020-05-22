@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Station {

@MappedSuperclass
public abstract class AbstractStationCompany extends Station {
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Company company;

@Entity
public class StationCompany extends AbstractStationCompany {

@MappedSuperclass
public class AbstractStationAnalysis extends AbstractStationCompany {
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Analysis analysis;

@Entity
public class StationAnalysis extends AbstractStationAnalysis {

@Entity
public class StationVariant extends AbstractStationAnalysis {