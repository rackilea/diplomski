// Create RoomDimension and RoomCarpet objects.
    CarpetCalculatorProgram calculatorProgram = new CarpetCalculatorProgram();
    CarpetCalculatorProgram.RoomDimension dimensions = calculatorProgram.new RoomDimension(length,
            width);
    CarpetCalculatorProgram.RoomCarpet roomCarpet = calculatorProgram.new RoomCarpet(dimensions,
            CARPET_PRICE_PER_SQFT);