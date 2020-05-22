public ItineraryDataEntry(final ItineraryDataEntryBuilder builder) {
    this.type = builder.type;
    this.field01 = builder.field01;
    this.field02 = builder.field02;
    this.field03 = builder.field03;
    this.field04 = builder.field04;
    this.field05 = builder.field05;
    this.field06 = builder.field06;
    this.field07 = builder.field07;
    this.field08 = builder.field08;
    this.field09 = builder.field09;
    this.field10 = builder.field10;
    this.field11 = builder.field11;
    this.field12 = builder.field12;
    this.field13 = builder.field13;
    this.field14 = builder.field14;
    this.legNumber = builder.legNumber;
    this.origin = builder.origin;
    this.destination = builder.destination;
    this.carrier = builder.carrier;
    this.fareBasisCode = builder.fareBasisCode;
    this.serviceClass = builder.serviceClass;
    this.flightDate = builder.flightDate;
    this.departureTime = builder.departureTime;
  }
...

    public ItineraryDataEntryBuilder origin(final String param) {
      this.origin = param;
      return this;
    }

    public ItineraryDataEntryBuilder destination(final String param) {
      this.destination = param;
      return this;
    }

    public ItineraryDataEntryBuilder carrier(final String param) {
      this.carrier = param;
      return this;
    }
...