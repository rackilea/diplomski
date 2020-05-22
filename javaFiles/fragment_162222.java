// Dependency Injected
private someService;

public void processCapability(..., String capabilityId) {

  Boolean isCapabilityProcessed = processDispenseCapabilities(...) || processUpdateCapabilities(..);

  if(isCapabilityProcessed) {
    throw exception("Invalid Capability");
  }
}

private Boolean processDispenseCapabilities(..,String capabilityId) {

  Boolean result = false;

  switch (capabilityId) {
        case ORDER_DISPENSED_WITH_SOURCE1:
            someService.doDispense1();
            result = true;
        case ORDER_DISPENSED_WITH_SOURCE2:
            someService.doDispense2();
            result = true;
        case ORDER_REJECTED:
            someService.doReject();
            result = true;
            ...
        default: //do nothing
    }

  return result;
}

private Boolean processUpdateCapabilities(..,String capabilityId) {
  Boolean result = false;

    switch (capabilityId) {
        case ORDER_CANCEL:
            someService.doCancel();
            result = true;
        case ORDER_PURGE:
            someService.doPurge();
            result = true;
            ...
        default: //do nothing
    }

  return result;
}