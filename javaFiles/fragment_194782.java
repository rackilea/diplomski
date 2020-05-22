public double usedFuel(String AccountID, String DeviceID, long time, double fuel){
        Double useFuel = 0.0;
        try{
            useFuel = Double.parseDouble(fuelLevelStart(AccountID, DeviceID, time)) - Double.parseDouble(fuelLevelEnd(AccountID, DeviceID, time, fuel));
            System.out.printf(" ",useFuel);
        }
        catch(Exception e){

        }
        return useFuel;
    }