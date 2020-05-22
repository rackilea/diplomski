@PaymentPlanLocking
  @Override
  public HoldResponse execute(HoldRequest holdRequest) throws PaymentServiceException {
    return doExecute(holdRequest);
  }

  @PaymentPlanLocking
  @Override
  public HoldResponse doExecute(HoldRequest holdRequest) throws PaymentServiceException {
    return new HoldResponse();
  }