public Builder setClientId(String clientId) {
    checkArgument(!Strings.isNullOrEmpty(clientId),
      "clientId may not be null or an empty string, found '%s'.", clientId);
    final Integer id = Ints.tryParse(clientId);
    if (id != null) {
      checkArgument(id.intValue() > 0,
        "clientId must be a positive number, found: '%s'.", clientId);
    }
    this.clientId = clientId;
    return this;
  }