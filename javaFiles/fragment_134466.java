public Builder setClientId(String clientId) {
    final Integer id = Ints.tryParse(clientId);
    checkArgument(id != null && id.intValue() > 0,
      "clientId must be a positive number, found: '%s'.", clientId);
    this.clientId = clientId;
    return this;
  }