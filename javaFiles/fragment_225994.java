class BoilingTemperature implements Temperature {
   public boolean within(final int temperature) {
      return temperature > 99;
   }

   public String message() {
      return "Water boiling";
   }
}

class FreezingTemperature implements Temperature {
   public boolean within(final int temperature) {
      return temperature < 1; // Should be 3 degree! But anyway.
   }

   public String message() {
      return "Water freezing";
   }
}