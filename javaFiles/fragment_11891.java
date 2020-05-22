@Service
public class CargoPage extends TablePageTemplate {

    private VehicleService vehicleService;

    @Autowired
    public CargoPage(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    public void init() {
        getAboveTableLine().getChildren().addAll(getAboveTableLineSetup());
        setTable(getTable(), vehicleService.findAll(), VehicleEntity.getTableMapping());
    }
}