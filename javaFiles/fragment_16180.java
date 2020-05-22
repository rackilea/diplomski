/**
   * Sets the checks if is delivery receipt requested.
   *
   * @param value the new checks if is delivery receipt requested
   * @throws Exception the exception
   */
  public void setIsDeliveryReceiptRequested(Boolean value) throws Exception {
    this.getPropertyBag().setObjectFromPropertyDefinition(
        EmailMessageSchema.IsDeliveryReceiptRequested, value);
  }