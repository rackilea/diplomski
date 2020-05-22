Locations [] createLocations(int count) {

        Locations [] arrayOfLocations = new Locations[count];

        for (int i = 0; i < count; i++) {
            arrayOfLocations[i] = new Locations();
        }

        return arrayOfLocations;
    }
} // YOU NEED TO ADD A CLOSING BRACE TO FINALIZE THE CLASS DEFINITION