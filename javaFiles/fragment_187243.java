try{
        String distance = "29.336 m"; //Notice that one space between digit and unit.
        String arr_distance = distance.split(" "); //split on space
        Double digit_distance =Double.parseDouble(arr_distance [0]); // First element as a double to digit.
        String unit_distance = arr_distance[1]; // Second Element as String to unit
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(digit_distance);
        switch(unit_distance){
              case "m":
                  System.out.println("DISTANCEHECKER" + df.format(digit_distance));
                  break;
              case "km":   
                  System.out.println("DISTANCEHECKER" + df.format(digit_distance*1000));
                  break;
             ............
             ................  //more Code Omitted.as per your requirement
     }
     }catch(Exception e){
            System.out.println(e.getMessage());
        }