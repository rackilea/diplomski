class YourCustomTemperature implements Temperature {
   public boolean within(final int temperature) {
      return temperature > 6 && temperature < 40;
   }

   public String message() {
      return "Your custom message";
   }
}