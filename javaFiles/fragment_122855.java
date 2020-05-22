public Object doSomething() throws CustomException {
  try {
    return theirSvc.getData();
  } catch (ThirdPartyException ex) {
    throw new CustomException("Failed to obtain requested data.");
    // or: throw new CustomException("Failed to obtain requested data.", ex) ?
  }
}