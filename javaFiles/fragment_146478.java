class House{
        final String road;
        final int houseNumber;

         House(String road, int houseNumber) {
             this.road = road;
             this.houseNumber = houseNumber;
         }

         @Override
         public String toString() {
             return "House{" +
                     "road='" + road + '\'' +
                     ", houseNumber=" + houseNumber +
                     '}';
         }
     }