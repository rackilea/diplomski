String[] bits = properties.getProperty(this.name(), "").split(":");
if (bits.length == 2) {
  server = bits[0];
  port = Integer.valueOf(bits[1]); 
} else {
  // Log the corruption or whatever...
}