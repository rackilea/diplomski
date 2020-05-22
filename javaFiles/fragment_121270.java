case ("in"):
        {
            switch (convertTo)
            {
                case ("mm"):
                {
                    System.out.println("The value of " + value + "inches to mm is: " + (value * MILLIMETER_PER_INCH));
                    break;
                }
                case ("cm"):
                {
                    System.out.println("The value of " + value + "inches to cm is: " + (value * CENTIMETER_PER_INCH));
                    break;
                }
                case ("m"):
                {
                    System.out.println("The value of " + value + "inches to m is: " + (value * METER_PER_INCH));
                    break;
                }
                case ("km"):
                {
                    System.out.println("The value of " + value + "inches to km is: " + (value * KILOMETER_PER_INCH));
                    break;
                }
                default:
                {
                    System.out.println("output units not recognized, must be mm, cm, m, km");
                    break;
                }
            }
            break; // breaks the outer switch case "in"
        }