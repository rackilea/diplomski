package sample;

import java.util.List;

public interface IFlightAgent {
    List<IFlight> getFlight();
    void reserve(IFlight flight);
}

public interface ICarAgent {
    List<ICar> getCars();
    void reserve(ICar car);
}

public interface IHotelAgent {
    List<IHotel> getHotels();
    void reserve(IHotel hotel);
}

package sample;

import com.javadude.annotation.Bean;
import com.javadude.annotation.Delegate;

@Bean(delegates = {
    @Delegate(type = IHotelAgent.class,
              property = "hotelAgent",
              instantiateAs = HotelAgentImpl.class),
    @Delegate(type = ICarAgent.class,
              property = "carAgent",
              instantiateAs = CarAgentImpl.class),
    @Delegate(type = IFlightAgent.class,
              property = "flightAgent",
              instantiateAs = FlightAgentImpl.class)
    }
)
public class TravelAgent extends TravelAgentGen
    implements IHotelAgent, ICarAgent, IFlightAgent
{
    // generated superclass TravelAgentGen will create instances
    //   of the "instantiateAs" classes and delegate the interface
    //   methods to them
}