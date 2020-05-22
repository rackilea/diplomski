@Mapper
public interface CarMapper {

    Car map(CarDto carDto, @Context CarContext context);

    Wheel map(WheelDto wheelDto, @Context CarContext context);

}

public class CarContext {

    private String lastUserId;

    @BeforeMapping
    public void beforeCarMapping(CarDto carDto) {
        this.lastUserId = carDto.getUserId();
    }

    @AfterMapping
    public void afterWheelMapping(@MappingTarget Wheel wheel) {
        wheel.setLastUserId(lastUserId);
    }

}