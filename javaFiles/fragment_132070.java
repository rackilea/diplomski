@Component
public class Car {

    @Autowired
    public Car(Engine engine, Optional<Transmission> transmission) {
        this.engine = engine;
        this.transmission = transmission.orElse(null);
    }
}