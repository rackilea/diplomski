public Vehicle nextVehicle()
    {  
        Vehicle nV = null;

        try
        {      
            if (currentVehicle < vehicleArray.size())
            {
                nV = vehicleArray.get(currentVehicle++);
            } else {
                if (vehicleArray.size() > 0) {
                    nV = verhicleArray.get(0);
                    currentVehicle = 1;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("No more vehicles listed");
        }   

        return nV;
    }