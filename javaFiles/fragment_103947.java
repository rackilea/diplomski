import com.example.fuelfacility.FuelFacility;
import com.example.fuelfacility.PumpEngineConnection;
public Controller {
  private final FuelFacility fuelFacility;

  public Controller(FuelFacility fuelFacility){
    this.fuelFacility = fuelFacility;
  }

  public void example(){
     String pumpId = "pumpId";
     String engineId = "engineId";

     PumpEngineConnection connection = fuelFacility.connect("pumpId", "engineId");
     connection.activate();
  }
}