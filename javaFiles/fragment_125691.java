@Mapper
public interface CarMapper {

    @Mapping(source = "carDetailDetail.model", target = "model")
    CarDto carToCarDto(Car car);

    List<CarDto> carsToCarDtos(List<Car> cars);       
}