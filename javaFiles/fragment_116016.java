Locations[] createLocations(int x){
        int iterate = 1;
        int loopMax = x;
        Locations[] arrayOfLocations = new Locations[x -1];
        while (iterate <= loopMax){
            int index = iterate -1;
            arrayOfLocations[index] = new Locations();
            iterate += 1;
        }
         return arrayOfLocations;
    }
} // YOU NEED TO ADD A CLOSING BRACE TO FINALIZE THE CLASS DEFINITION