import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarRentalStation {

    private String location = "Atlanta";
    private Map<String, Car> cars = new HashMap<String, Car> (){{
        put("A123", new Car("A123", "BMW 120d"));
        put("B321", new Car("B321", "Volkswagen Golf 2.0 TDI"));
    }};

    public String getLocation() {
        return location;
    }

    @JsonGetter("cars")
    public List<Car> getCarsAsList() {
        return cars.values().stream().collect(Collectors.<Car>toList());
    }

    @JsonSetter("cars")
    public void setCarsAsList(List<Car> cars) {
        Map<String, Car> deserializedCars = cars.stream().collect(Collectors.toMap(Car::getVin, car -> car));
        this.cars = deserializedCars;
    }

    //toString ...    
}