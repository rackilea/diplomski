@Mapper
public interface CarMapper {

    Car map(CarDto carDto);

    @AfterMapping
    default void afterCarMapping(@MappingTarget Car car, CarDto carDto) {
        car.getWheels().forEach(wheel -> wheel.setLastUserId(carDto.getUserId()));
    }
}