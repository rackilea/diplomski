public Measurement(@Attribute(name="date") Date date,
                   @Attribute(name="value") float value,
                   @Attribute(name="engineer") String engineer) {
    super();
    this.date = date;
    this.value = value;
    this.engineer = engineer;
}