public GenericMissile(double x) {
  this(x, "");
}

public GenericMissile(double x, String optionalParam) {
  this.x = x;
  this.optionalParam = optionalParam;
  initSpecificParams();
}