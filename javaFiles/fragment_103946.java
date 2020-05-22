public class OilAPIFuelFacility implements FuelFacility {
  private final OilAPI oil;
  public OilAPIFuelFacility(OilAPI oil){ this.oil = oil; }

  @Override
  public PumpEngineConnection connect(String pumpId, String engineId){
     Geyser geyser = oil.getGeyserWithId(pumpId);
     Burner burner = oil.getBurnerWithId(engineId);
     oil.createConnectionBetweenGeyserAndBurner(geyser, burner);
     return this.new GeyserBurnerConnection(geyser, burner);
  }

  private class GeyserBurnerConnection implements PumpEngineConnection {
     private final Geyser geyser;
     private final Burner burner;

     private GeyserBurnerConnection(Geyser geyser, Burner burner){
       this.geyser = geyser;
       this.burner = burner;
     }

     @Override
     public void activate() {
        OilAPIFuelFacility.this.oil.activateGeyser(this.geyser);
        OilAPIFuelFacility.this.oil.activateBurner(this.burner);
     }
  }
}