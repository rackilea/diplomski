private  static  boolean  printColumnHeaders(Vehicle vehicle, boolean printFull, boolean isFirst) {

                if(isFirst && printFull){
                    System.out.println(vehicle.printFullHeadings());
                }                                       
                else if (isFirst){
                    System.out.println(vehicle.printSummaryHeadings());
                }

            return false;
        }