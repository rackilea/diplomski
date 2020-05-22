//once you get resultset rs after executing query
    while(rs.next()){  
        String truckName = rs.getString("<name of truck column>");
        setTruckMileage(truckName);
    }

    private void setTruckMileage(String truckName){  
        Scanner kb = new Scanner (System.in);
        System.out.print("Enter mileage for truck " + truckName +" : ");

        Integer mileage = kb.nextInt();

        //save mileage entered by user
    }