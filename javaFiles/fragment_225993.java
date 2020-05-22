interface Temperature {
   /** Returns true if the temperature matches the criteria. */
   boolean within(final int temperature);

   /** Returns an appropriate, descriptive, message. */
   String message();
}