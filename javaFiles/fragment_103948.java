OilAPI oil1 = new OilAPI();
OilAPI oil2 = new OilAPI();
FuelFacility fuel1 = new FuelFacility(oil1);
FuelFacility fuel2 = new FuelFacility(oil2);
Engine engine = fuel1.getEngineForId("engineId");
Pump pump = fuel2.getPumpForId("pumpId");
engine.connectToPump(pump);